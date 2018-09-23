import { HttpClient } from '@angular/common/http'
import { Injectable } from '@angular/core'

import { List } from 'immutable'
import { of } from 'rxjs'
import { switchMap } from 'rxjs/operators'

import { ProgressBarService } from '@/components/progress-bar/progress-bar.service'

import { Music } from '@/music/Music'

import { environment } from 'env/environment'

@Injectable({
    providedIn: 'root'
})
export class MusicService {

    private API = environment.api.musics

    constructor(
        private http: HttpClient,
        private progressBarService: ProgressBarService
    ) { }

    public getAllBy(filter: string) {
        this.progressBarService.fetching(true)
        return this.http.get<any[]>(`${this.API}?filtro=${filter}`)
            .pipe(switchMap(({ data }: any) => {
                this.progressBarService.fetching(false)
                let list = List()
                data.forEach(item => list = list.push(new Music(item)))
                return of(list)
            }))
    }

}
