describe('Tests for Search UI', () => {

    it('Should search a music by author name', () => {
        cy.goHome()
        cy.get('[data-cy=input-musicOrPlaylistFilter]').type('Bruno {enter}')
        cy.get('[data-cy=table-musics] [data-cy=table-row]').should('to.be.visible')
        cy.get('[data-cy=table-musics] [data-cy=table-row]').should('to.be.visible')
    })

    it('Should search a music by name', () => {
        cy.goHome()
        cy.get('[data-cy=input-musicOrPlaylistFilter]').type('24k {enter}')
        cy.get('[data-cy=table-musics] [data-cy=table-row]').should('to.have.length', 1)
        cy.get('[data-cy=table-musics] [data-cy=table-row]').should('to.be.visible')
    })

    it('Should search a playlist by username', () => {
        cy.goHome()
        cy.get('[data-cy=input-userFilter]').type('default {enter}')
        cy.get('[data-cy=table-playlists] [data-cy=table-row]').should('to.be.visible')
    })

})
