import * as _ from 'lodash'

import { HttpClient } from '@angular/common/http'
import { Injectable } from '@angular/core'

import { empty, of } from 'rxjs'
import { switchMap, tap } from 'rxjs/operators'

import { Map } from 'immutable'

import { not } from '@/utils/functions'

import { ProgressBarService } from '@/components/progress-bar/progress-bar.service'

import { environment } from 'env/environment'

import { Music } from '@/music/Music'
import { Playlist } from '@/playlist/Playlist'

@Injectable({
    providedIn: 'root'
})
export class PlaylistService {

    private API = environment.api.playlists

    constructor(
        private http: HttpClient,
        private progressBarService: ProgressBarService
    ) { }

    public addMusic(playlistId: string, musics: Music[]) {
        this.progressBarService.fetching(true)
        return this.http.put<any>(`${this.API}/${playlistId}/musicas`, musics)
            .pipe(tap(() => this.progressBarService.fetching(false)))
    }

    public getAllBy(filter: string) {
        this.progressBarService.fetching(true)
        return this.http.get<any[]>(`${this.API}?user=${filter}`)
            .pipe(switchMap(({ data }: any) => {
                this.progressBarService.fetching(false)
                if (not(_.isEmpty(data))) {
                    return of(Map(new Playlist(data[0])))
                }
                return empty()
            }))
    }

    public removeMusic(playlistId: string, musicId: string) {
        this.progressBarService.fetching(true)
        return this.http.delete<any>(`${this.API}/${playlistId}/musicas/${musicId}`)
            .pipe(tap(() => this.progressBarService.fetching(false)))
    }

}
