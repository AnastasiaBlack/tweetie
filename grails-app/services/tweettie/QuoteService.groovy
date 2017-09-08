package tweettie

import grails.transaction.Transactional
import twee.Quote
import twee.User

@Transactional
class QuoteService {

    def getStaticQuote() {
        return new Quote(author: "Alice", content: "We are all insane here.")
    }

    def getRandomQuote() {
        List<Quote> allQuotes = Quote.getAll()
        Quote randomQuote
        if (allQuotes.size() > 0) {
            int randomIdx = new Random().nextInt(allQuotes.size())
            randomQuote = allQuotes[randomIdx]
        } else {
            randomQuote = getStaticQuote()
        }
        return randomQuote
    }

    def postQuote(String content, User author){
        new Quote(author: author, content : content).save()
    }
}
