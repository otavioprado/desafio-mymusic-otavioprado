import { Component, Input, Output, EventEmitter } from '@angular/core'

import { List } from 'immutable'

import { Music } from '@/music/Music'

@Component({
    selector: 'app-table',
    templateUrl: './table.component.html'
})
export class TableComponent {

    @Input() columns = {}
    @Input() list = []

    @Output() itemSelecionado = new EventEmitter()

    private itensSelecionados = List()

    selecionado(item) {
        const itemEncontrado = this.itensSelecionados.toJS().findIndex((i: Music) => i.nome === item.nome)
        if (itemEncontrado >= 0) {
            this.itensSelecionados = this.itensSelecionados.delete(itemEncontrado)
        } else {
            this.itensSelecionados = this.itensSelecionados.push(item)
        }
        this.itemSelecionado.emit(this.itensSelecionados)
    }

}
