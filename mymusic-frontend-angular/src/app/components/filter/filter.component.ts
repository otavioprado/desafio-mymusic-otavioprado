import { types } from '@/constants/EventsTypes'

import _ from 'lodash'

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

    filterForm: FormGroup
    userFilter = ''

    constructor(
        private eventService: EventService,
        private formBuilder: FormBuilder
    ) { }

    ngOnInit(): void {
        this.filterForm = this.formBuilder.group({
            musicOrPlaylistFilter: ['']
        })
    }

    searchByMusicOrPlaylist() {
        const musicOrPlaylistFilter = this.filterForm.get('musicOrPlaylistFilter').value
        if (not(_.isEmpty(musicOrPlaylistFilter))) {
            this.eventService.emit(types.SEARCH_BY_MUSIC_OR_ARTIST, { filter: musicOrPlaylistFilter })
            this.filterForm.reset()
        }
    }

    searchByUser() {
        if (not(_.isEmpty(this.userFilter))) {
            this.eventService.emit(types.SEARCH_BY_USER, { filter: this.userFilter })
            this.userFilter = ''
        }
     }

}
