import { HttpClient } from '@angular/common/http'
import { Injectable } from '@angular/core'

import { List } from 'immutable'
import { of } from 'rxjs'
import { switchMap } from 'rxjs/operators'

import { Music } from '@/music/Music'

import { environment } from 'env/environment'

@Injectable({
    providedIn: 'root'
})
export class MusicService {

    private API = environment.api.url

    constructor(private http: HttpClient) { }

    public getAllBy(filter: string) {
        return this.http.get<any[]>(`${this.API}/5ba429072f00006d00968af1?filter=${filter}`)
            .pipe(switchMap((data: any) => {
                let list = List()
                data.list.forEach(item => list = list.push(new Music(item)))
                return of(list)
            }))
    }

}
