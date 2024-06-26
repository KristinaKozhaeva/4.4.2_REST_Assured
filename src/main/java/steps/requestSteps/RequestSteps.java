package steps.requestSteps;

import configuration.RequestBuilder;
import entity.Books;
import models.requests.RequestGetBooks;
import models.requests.RequestPostBooksXML;
import models.requests.RequestSaveBooks;
import models.responses.ResponseSaveBooks;

import java.util.List;

import static io.restassured.RestAssured.given;

public class RequestSteps {

    public static List<Books> getBooksByAuthor(RequestGetBooks requestGetBooks) {
        return given()
                .spec(RequestBuilder.requestGetBookSpec(requestGetBooks))
                .get()
                .then()
                .extract()
                .jsonPath()
                .getList("books", Books.class);
    }

    public static List<Books> getBooksByAuthorXML(RequestPostBooksXML requestPostBooksXML) {
        return given()
                .spec(RequestBuilder.requestPostBookSpecXML(requestPostBooksXML))
                .post()
                .then()
                .extract()
                .xmlPath()
                .getList(".", Books.class);
    }

    public static ResponseSaveBooks saveBook(RequestSaveBooks requestSaveBooks) {
        return given()
                .spec(RequestBuilder.requestSaveBookSpec(requestSaveBooks))
                .post()
                .as(ResponseSaveBooks.class);
    }
}

