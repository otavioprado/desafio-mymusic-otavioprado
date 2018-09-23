import { types } from '@/constants/EventsTypes'

import * as _ from 'lodash'

import { Component, OnInit } from '@angular/core'

import { List, Map } from 'immutable';

import { EventService } from '@/services/event.service'
import { MusicService } from '@/music/music.service'
import { PlaylistService } from '@/playlist/playlist.service'

import { not } from '@/utils/functions';

import { faAngleDoubleLeft, faAngleDoubleRight } from '@fortawesome/free-solid-svg-icons'

import { Music } from '@/music/Music'

@Component({
    selector: 'app-playlist-list',
    styleUrls: [ './playlist-list.component.css' ],
    templateUrl: './playlist-list.component.html'
})
export class PlaylistListComponent implements OnInit {

    faAngleDoubleLeft = faAngleDoubleLeft
    faAngleDoubleRight = faAngleDoubleRight

    columns = [ 'musicName', 'artistName' ]

    musics = List()
    musicError = ''
    musicSelected = null
    musicsSelected = null

    playlist = Map()
    playlistError = ''

    constructor(
        private eventService: EventService,
        private musicService: MusicService,
        private playlistService: PlaylistService
    ) { }

    ngOnInit(): void {
        this.eventService.listen(types.SEARCH_BY_MUSIC_OR_ARTIST).subscribe(({ data }) => this.searchByMusicOrArtist(data))
        this.eventService.listen(types.SEARCH_BY_USER).subscribe(({ data }) => this.searchByUser(data))
    }

    addMusic() {
        if (not(_.isNull(this.musicsSelected))) {
            if (not(_.isEmpty(this.musicsSelected.toJS()))) {
                const playlistId: string = this.playlist.get('id') as string
                if (not(_.isEmpty(playlistId))) {
                    this.playlistService.addMusic(playlistId, this.musicsSelected.toJS())
                        .subscribe(() => {
                            const musicas = this.playlist.get('musicas') as Music[]
                            this.playlist = this.playlist.set('musicas', musicas.concat(this.musicsSelected.toJS()))
                            this.musicSelected = null
                        })
                } else {
                    this.playlistError = 'Você precisa buscar uma playlist para adicioná-la uma música'
                }
            } else {
                this.musicError = 'Você precisa selecionar pelo menos uma música para adicioná-la na Playlist'
            }
        } else {
            this.musicError = 'Você precisa selecionar pelo menos uma música para adicioná-la na Playlist'
        }
    }

    removeMusic() {
        const playlistId: string = this.playlist.get('id') as string
        if (not(_.isEmpty(playlistId))) {
            if (this.musicSelected) {
                this.playlistService.removeMusic(playlistId, this.musicSelected.id)
                    .subscribe(() => {
                        const musicas = this.playlist.get('musicas') as Music[]
                        this.playlist = this.playlist.set('musicas', musicas.filter(music => music.id !== this.musicSelected.id))
                    })
            } else {
                this.playlistError = 'Você precisa selecionar pelo menos uma música para removê-la na Playlist'
            }
        } else {
            this.playlistError = 'Você precisa buscar uma playlist para remover uma música'
        }
    }

    handleMusicSelect(musicsSelected) {
        this.musicsSelected = musicsSelected
        this.musicError = ''
    }

    handlePlaylistSelect(musicSelected) {
        this.musicSelected = musicSelected
        this.playlistError = ''
    }

    searchByMusicOrArtist({ filter }) {
        this.musicService.getAllBy(filter)
            .subscribe(list => this.musics = list)
    }

    searchByUser({ filter }) {
        this.playlistService.getAllBy(filter)
            .subscribe((item: any) => {
                this.playlist = item
                this.playlistError = ''
            })
     }

}
