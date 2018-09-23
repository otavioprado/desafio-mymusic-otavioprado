import { BrowserModule } from '@angular/platform-browser'
import { NgModule } from '@angular/core'
import { HttpClientModule } from '@angular/common/http'

import { FontAwesomeModule } from '@fortawesome/angular-fontawesome'

import { AppComponent } from './app.component'

import { ComponentsModule } from '@/components/components.module'

import { PlaylistListModule } from '@/playlist/pages/list/playlist-list.module'

@NgModule({
    declarations: [
        AppComponent
    ],
    imports: [
        BrowserModule,
        ComponentsModule,
        FontAwesomeModule,
        HttpClientModule,
        PlaylistListModule
    ],
    providers: [],
    bootstrap: [ AppComponent ]
})
export class AppModule { }
