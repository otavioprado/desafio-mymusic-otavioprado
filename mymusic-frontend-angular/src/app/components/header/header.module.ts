import { NgModule } from '@angular/core'
import { CommonModule } from '@angular/common'

import { HeaderComponent } from '@/components/header/header.component'
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
        MenuModule
    ]
})
export class HeaderModule { }
