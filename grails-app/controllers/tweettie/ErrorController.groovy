package tweettie

class ErrorController {

    def error() {
        render view: 'error'
    }

    def invalid() {
        render view: 'error'
    }

    def denied() {
        render view: 'error'
    }

    def notFound() {
        render view: 'notFound'
    }

}
