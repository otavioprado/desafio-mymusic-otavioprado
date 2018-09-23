import { Component, OnInit } from '@angular/core'

import { ProgressBarService } from '@/components/progress-bar/progress-bar.service'

@Component({
    selector: 'app-progress-bar',
    styleUrls: [ './progress-bar.component.css' ],
    templateUrl: './progress-bar.component.html'
})
export class ProgressBarComponent implements OnInit {

    public inProgress = false

    constructor(private progressBarService: ProgressBarService) { }

    ngOnInit(): void {
        this.progressBarService.isFetching()
            .subscribe(({ isFetching }) => this.inProgress = isFetching)
    }

}
