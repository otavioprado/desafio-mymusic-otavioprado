describe('Tests for Playlist UI', () => {

    it('Should remove a music', () => {
        cy.goHome()

        cy.log('Searching and selecting a music to remove')
        cy.get('[data-cy=input-userFilter]').type('default {enter}')
        cy.get('[data-cy=table-playlists] [data-cy=table-row]:first-child [data-cy=table-select-item]').click()
        cy.get('[data-cy=table-playlists] [data-cy=table-row]').should('to.be.visible')
        cy.get('[data-cy=btn-deleteMusic]').click()
    })

})
