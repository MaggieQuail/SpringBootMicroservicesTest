package com.ololo.springBootOloloDemo;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import javax.ws.rs.GET;
//import javax.ws.rs.Path;
//import javax.ws.rs.PathParam;
//import javax.ws.rs.Produces;
//import javax.ws.rs.core.MediaType;

//@Component
//@Path("/")
@RestController
@RequestMapping("/")
public class PortfolioImpl implements InitializingBean {
    private Object[][][][] clientPortfolios;
//    @GET
//    @Path("customer/{customer-id}")
//    @Produces(MediaType.APPLICATION_JSON)
    // a portfolio consists of an array of arrays, each containing an array of
    // stock ticker and associated shares
    @GetMapping("/customer/{customer-id}")
    public Object[][][] getPortfolios( @PathVariable("customer-id") int customerId)
    {
        return clientPortfolios[customerId];
    }



    @GetMapping("/customer/{customer-id}/portfolio/{portfolio-id}")
    public Object[][] getPortfolio(@PathVariable("customer-id") int customerId,
                                   @PathVariable("portfolio-id") int portfolioId) {
        return getPortfolios(customerId)[portfolioId];
    }

    @GetMapping("/test")
    public String getTest()
    {
        return "Hiiii";
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        Object[][][][] clientPortfolios =
                {
                        {
                                // 3 customers, 3 portfolios each
                                {new Object[]{"JPM", 10201}, new Object[]{"GE", 20400}, new Object[]{"UTX", 38892}},
                                {new Object[]{"KO", 12449}, new Object[]{"JPM", 23454}, new Object[]{"MRK", 45344}},
                                {new Object[]{"WMT", 39583}, new Object[]{"DIS", 95867}, new Object[]{"TRV", 384756}},
                        }, {
                                {new Object[]{"GE", 38475}, new Object[]{"MCD", 12395}, new Object[]{"IBM", 91234}},
                                {new Object[]{"VZ", 22342}, new Object[]{"AXP", 385432}, new Object[]{"UTX", 23432}},
                                {new Object[]{"IBM", 18343}, new Object[]{"DIS", 45673}, new Object[]{"AAPL", 23456}},
                           }, {
                                {new Object[]{"AXP", 34543}, new Object[]{"TRV", 55322}, new Object[]{"NKE", 45642}},
                                {new Object[]{"CVX", 44332}, new Object[]{"JPM", 12453}, new Object[]{"JNJ", 45433}},
                                {new Object[]{"MRK", 32346}, new Object[]{"UTX", 46532}, new Object[]{"TRV", 45663}},
                              }
                };

        this.clientPortfolios = clientPortfolios;
    }


}
