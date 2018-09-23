import { types } from '@/constants/EventsTypes'

import * as _ from 'lodash'

import { Component, OnInit } from '@angular/core'
import { FormGroup, FormBuilder } from '@angular/forms'

import { not } from '@/utils/functions'

import { EventService } from '@/services/event.service'

import { faSearch } from '@fortawesome/free-solid-svg-icons'

@Component({
    selector: 'app-filter',
    templateUrl: './filter.component.html'
})
export class FilterComponent implements OnInit {

    faSearch = faSearch

    musicOrPlaylistForm: FormGroup
    userForm: FormGroup

    constructor(
        private eventService: EventService,
        private formBuilder: FormBuilder
    ) { }

    ngOnInit(): void {
        this.musicOrPlaylistForm = this.formBuilder.group({ musicOrPlaylistFilter: [''] })
        this.userForm = this.formBuilder.group({ userFilter: [''] })
    }

    filter(form: FormGroup, type: string, filter: any) {
        const value = form.get(filter).value
        if (not(_.isEmpty(value))) {
            this.eventService.emit(type, { filter: value })
            form.reset()
        }
    }

    searchByMusicOrPlaylist() {
        this.filter(this.musicOrPlaylistForm, types.SEARCH_BY_MUSIC_OR_ARTIST, 'musicOrPlaylistFilter')
    }

    searchByUser() {
        this.filter(this.userForm, types.SEARCH_BY_USER, 'userFilter')
     }

}
