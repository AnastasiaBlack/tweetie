package tweettie


import grails.test.mixin.integration.Integration
import grails.transaction.*
import spock.lang.*
import twee.Quote

@Integration
@Rollback
class QuoteSpec extends Specification {
    @Shared int initCount

    def setup() {
        initCount= Quote.count()
        new Quote(author:"Keith", content:"It is pretty cold in Canada, eh?").save(flush:true)
    }

    def cleanup() {
    }

    void "test Quote is saved"() {
        expect:"count increased by one"
            Quote.count() == initCount+1
    }
}
