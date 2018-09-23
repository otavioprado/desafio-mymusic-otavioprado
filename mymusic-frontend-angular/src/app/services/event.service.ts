import { Injectable } from '@angular/core'

import { Observable, Subject, empty, of } from 'rxjs'
import { switchMap } from 'rxjs/operators'

@Injectable({
    providedIn: 'root'
})
export class EventService {

    private event: Subject<any> = new Subject<any>();

    emit(topic, data) {
        this.event.next({ topic, data });
    }

    listen(topic): Observable<any> {
        return this.event
            .pipe(switchMap(data => {
                if (topic === data.topic) {
                    return of(data)
                }
                return empty()
            }))
    }

}
