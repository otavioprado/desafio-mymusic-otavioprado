import { HttpClient } from '@angular/common/http'
import { Injectable } from '@angular/core'

import { List } from 'immutable'
import { of } from 'rxjs'
import { switchMap } from 'rxjs/operators'

import { Playlist } from '@/playlist/Playlist'

import { environment } from 'env/environment'

@Injectable({
    providedIn: 'root'
})
export class PlaylistService {

    private API = environment.api.url

    constructor(private http: HttpClient) { }

    public getAllBy(filter: string) {
        return this.http.get<any[]>(`${this.API}/5ba42b4b2f00005500968af6?filter=${filter}`)
            .pipe(switchMap((data: any) => {
                let list = List()
                data.list.forEach(item => list = list.push(new Playlist(item)))
                return of(list)
            }))
    }

}
