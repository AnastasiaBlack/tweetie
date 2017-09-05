package tweettie

import grails.test.mixin.TestFor
import grails.test.mixin.integration.Integration
import grails.transaction.*
import spock.lang.*
import twee.Quote

@Integration
@Rollback
@TestFor(QuoteService)
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

    void "test Random quote is generated"(){
        given:
        String randomQuote = service.getRandomQuote()
        String staticQuote = service.staticQuote

        if(Quote.count()!=null){
        expect:"Random quote is generated"
        randomQuote!=staticQuote}
        else{
            expect:"Static quote is returned"
            service.getStaticQuote().content == "We are all insane here."}
        }
    }
