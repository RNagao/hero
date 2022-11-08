class PostionTest {
    def "Should return X and X"() {
        given:
            Position position = new Position(2, 3)
        expect:
            position.getX() == 2
            position.getY() == 3
    }

    def "Should modify the position"() {
        given:
            Position position = new Position(2,3)
        when:
            position.setX(7)
            position.setY(8)
        then:
            position.getX() == 7
            position.getY() == 8
    }

    def "Should identify equal positions"(){
        given:
            Position position1 = new Position(2,3)
            Position position2 = new Position(2,3)
        when:
            position1.equals(position2) == true
    }
}
