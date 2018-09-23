import { Artist } from '@/artist/Artist'

export class Music {

    public id: string
    public nome: string
    public artistaId: string
    public artista: Artist

    constructor({ id, nome, artistaId, artista }) {
        this.id = id
        this.nome = nome
        this.artistaId = artistaId
        this.artista = new Artist(artista)
    }

}
