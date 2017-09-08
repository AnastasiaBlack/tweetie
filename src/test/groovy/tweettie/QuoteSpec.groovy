package tweettie

import grails.test.mixin.TestFor
import spock.lang.Shared
import spock.lang.Specification
import twee.Quote
import twee.User

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Quote)
class QuoteSpec extends Specification {
    @Shared
    User user

    def setup() {
        user = new User(username: "Masha", password: "masha")
    }


    def cleanup() {
    }

    void "test user constraints author balnk content  blank false"() {

        when:
        def quote = new Quote(author: user, content: content)
        quote.validate()

        then:
        quote.hasErrors() == !valid

        where:

        content                     | valid
        ""                          | false
        "Some content of the quote" | true
    }


}
