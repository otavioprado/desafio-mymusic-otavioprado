describe('Tests for Music UI', () => {

    it('Should add a new music', () => {
        cy.goHome()

        cy.log('Searching and selecting a music to add')
        cy.get('[data-cy=input-musicOrPlaylistFilter]').type('Bruno {enter}')
        cy.get('[data-cy=table-musics] [data-cy=table-row]').should('to.be.visible')

        cy.log('Searching a plaulist to receive a new music')
        cy.get('[data-cy=table-musics] [data-cy=table-row]:first-child [data-cy=table-select-item]').click()
        cy.get('[data-cy=input-userFilter]').type('default {enter}')
        cy.get('[data-cy=table-playlists] [data-cy=table-row]').should('to.be.visible')

        cy.log('Adding new music')
        cy.get('[data-cy=btn-addMusic]').click()
    })

})
