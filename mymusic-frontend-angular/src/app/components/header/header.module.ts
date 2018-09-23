import { NgModule } from '@angular/core'
import { CommonModule } from '@angular/common'

import { HeaderComponent } from '@/components/header/header.component'

import { ProgressBarModule } from '@/components/progress-bar/progress-bar.module'
import { MenuModule } from '@/components/menu/menu.module'

@NgModule({
    declarations: [
        HeaderComponent
    ],
    exports: [
        HeaderComponent
    ],
    imports: [
        CommonModule,
        MenuModule,
        ProgressBarModule
    ]
})
export class HeaderModule { }
