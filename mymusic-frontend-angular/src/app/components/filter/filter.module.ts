import { NgModule } from '@angular/core'
import { CommonModule } from '@angular/common'
import { FormsModule, ReactiveFormsModule } from '@angular/forms'

import { FontAwesomeModule } from '@fortawesome/angular-fontawesome'

import { FilterComponent } from '@/components/filter/filter.component'

@NgModule({
    declarations: [
        FilterComponent
    ],
    exports: [
        FilterComponent
    ],
    imports: [
        CommonModule,
        FontAwesomeModule,
        FormsModule,
        ReactiveFormsModule
    ]
})
export class FilterModule { }
