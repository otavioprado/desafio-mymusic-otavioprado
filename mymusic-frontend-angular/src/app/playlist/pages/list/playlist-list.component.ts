import { types } from '@/constants/EventsTypes'

import { Component, OnInit } from '@angular/core'

import { List } from 'immutable';

import { EventService } from '@/services/event.service'
import { MusicService } from '@/music/music.service'
import { PlaylistService } from '@/playlist/playlist.service'

import { faAngleDoubleLeft, faAngleDoubleRight } from '@fortawesome/free-solid-svg-icons'

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
    musicsSelected = List()

    playlists = List()

    constructor(
        private eventService: EventService,
        private musicService: MusicService,
        private playlistService: PlaylistService
    ) { }

    ngOnInit(): void {
        this.eventService.listen(types.SEARCH_BY_MUSIC_OR_ARTIST).subscribe(({ data }) => this.searchByMusicOrArtist(data))
        this.eventService.listen(types.SEARCH_BY_USER).subscribe(({ data }) => this.searchByUser(data))
    }

    handleMusicSelect(musicsSelected) {
        this.musicsSelected = musicsSelected
    }

    searchByMusicOrArtist({ filter }) {
        this.musicService.getAllBy(filter)
            .subscribe(list => this.musics = list)
    }

    searchByUser({ filter }) { }

}
