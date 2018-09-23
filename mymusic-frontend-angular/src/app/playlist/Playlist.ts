import { User } from '@/user/User';

export class Playlist {

    public id: string
    public playlistMusicas: object[]
    public usuario: User

    constructor({ id, playlistMusicas, usuario}) {
        this.id = id
        this.playlistMusicas = playlistMusicas
        this.usuario = usuario
    }

}
