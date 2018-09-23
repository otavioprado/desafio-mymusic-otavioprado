import { NgModule } from '@angular/core'
import { CommonModule } from '@angular/common'

import { FontAwesomeModule } from '@fortawesome/angular-fontawesome'
import { TableModule } from '@/components/table/table.module'

import { PlaylistListComponent } from '@/playlist/pages/list/playlist-list.component'

@NgModule({
    declarations: [
        PlaylistListComponent,
    ],
    exports: [
        PlaylistListComponent
    ],
    imports: [
        CommonModule,
        FontAwesomeModule,
        TableModule
    ]
})
export class PlaylistListModule { }
