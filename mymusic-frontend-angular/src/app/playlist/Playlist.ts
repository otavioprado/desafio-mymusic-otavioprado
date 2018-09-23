import { User } from '@/user/User';

export class Playlist {

    public id: string
    public musicas: object[]
    public usuario: User

    constructor({ id, musicas, usuario}) {
        this.id = id
        this.musicas = musicas
        this.usuario = usuario
    }

}
