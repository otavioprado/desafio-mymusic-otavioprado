import { NgModule } from '@angular/core'
import { CommonModule } from '@angular/common'

import { PlaylistListModule } from '@/playlist/pages/list/playlist-list.module'

import { PlaylistListComponent } from '@/playlist/pages/list/playlist-list.component'

@NgModule({
    declarations: [
        PlaylistListComponent
    ],
    imports: [
        CommonModule,
        PlaylistListModule
    ]
})
export class PlaylistModule { }
