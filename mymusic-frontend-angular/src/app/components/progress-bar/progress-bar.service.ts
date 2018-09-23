import { Injectable } from '@angular/core'

import { Subject, of } from 'rxjs'
import { switchMap } from 'rxjs/operators'

@Injectable({ providedIn: 'root' })
export class ProgressBarService {

    private subject = new Subject<any>()

    public fetching(isFetching) {
        this.subject.next({ isFetching })
    }

    public isFetching() {
        return this.subject.pipe(switchMap(({ isFetching }) => of({ isFetching })));
    }

}
