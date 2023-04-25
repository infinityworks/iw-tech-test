package infinityworks.com.iwtechtest.controller;

import infinityworks.com.iwtechtest.model.Authority;
import infinityworks.com.iwtechtest.model.AuthorityRatingItem;
import infinityworks.com.iwtechtest.model.FSAAuthority;
import infinityworks.com.iwtechtest.model.FSAAuthorityList;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class RatingController {

    private final RestTemplate restTemplate;
    public RatingController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    /**
     * Produces a list of authorities, for the select dropdown
     *
     * @return list of authorities
     */
    //@RequestMapping(value = "", produces = "application/json")
    @RequestMapping("/api")
    public List<Authority> getList() {

        HttpHeaders headers = new HttpHeaders();
        headers.set("x-api-version", "2");
        HttpEntity<FSAAuthorityList> entity = new HttpEntity<>(headers);

        ResponseEntity<FSAAuthorityList> restRes = restTemplate.exchange("http://api.ratings.food.gov.uk/Authorities", HttpMethod.GET, entity, FSAAuthorityList.class);

        FSAAuthorityList res = restRes.getBody();

        List<Authority> authorityList = new ArrayList<>();
        for (FSAAuthority fsaAuthority : res.getFsaAuthorityList()) {
            authorityList.add(new Authority(fsaAuthority.getId(), fsaAuthority.getName()));
        }

        return authorityList;
    }

    /**
     * Produces the ratings for a specific authority for the table
     *
     * @param authorityId the authority to calculate ratings for
     * @return the ratings to display
     */
    @RequestMapping("/api/{authorityId}")
    public List<AuthorityRatingItem> getAuthority(@PathVariable("authorityId") int authorityId) {

        //This is just sample data to demonstrate the contract of the API
        if (authorityId == 1) {
            return Arrays.asList(
                    new AuthorityRatingItem("5-star", 22.41),
                    new AuthorityRatingItem("4-star", 43.13),
                    new AuthorityRatingItem("3-star", 12.97),
                    new AuthorityRatingItem("2-star", 1.54),
                    new AuthorityRatingItem("1-star", 17.84),
                    new AuthorityRatingItem("Exempt", 2.11)
            );
        } else {
            return Arrays.asList(
                    new AuthorityRatingItem("5-star", 50),
                    new AuthorityRatingItem("4-star", 0),
                    new AuthorityRatingItem("3-star", 0),
                    new AuthorityRatingItem("2-star", 0),
                    new AuthorityRatingItem("1-star", 25),
                    new AuthorityRatingItem("Exempt", 25)
            );
        }
    }

}