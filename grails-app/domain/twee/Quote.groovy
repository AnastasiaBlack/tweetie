package twee

class Quote {

    String content
    User author
    Date created = new Date()

    static constraints = {
        author(blank: false)
        content(maxSize: 1000, blank: false)
    }
}
