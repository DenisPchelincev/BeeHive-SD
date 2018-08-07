package ru.beehive.sd.controllers

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.cloud.client.discovery.DiscoveryClient
import org.springframework.web.bind.annotation.*

//import com.netflix.discovery.DiscoveryClient

@RestController
class MainController {

    @Autowired
    private val discoveryClient: DiscoveryClient? = null

    @ResponseBody
    @RequestMapping(value = "/", method = arrayOf(RequestMethod.GET))
    fun home(): String {
        return "<a href='showAllServiceIds'>Show All Service Ids</a>"
    }

    @ResponseBody
    @RequestMapping(value = "/showAllServiceIds", method = arrayOf(RequestMethod.GET))
    fun showAllServiceIds(): String {

        val serviceIds = this.discoveryClient!!.getServices()

        if (serviceIds == null || serviceIds!!.isEmpty()) {
            return "No services found!"
        }
        var html = "<h3>Service Ids:</h3>"
        for (serviceId in serviceIds!!) {
            html += "<br><a href='showService?serviceId=$serviceId'>$serviceId</a>"
        }
        return html
    }

    @ResponseBody
    @RequestMapping(value = "/showService", method = arrayOf(RequestMethod.GET))
    fun showFirstService(@RequestParam(defaultValue = "") serviceId: String): String {

        // (Need!!) eureka.client.fetchRegistry=true
        val instances = this.discoveryClient!!.getInstances(serviceId)

        if (instances == null || instances!!.isEmpty()) {
            return "No instances for service: $serviceId"
        }
        var html = "<h2>Instances for Service Id: $serviceId</h2>"

        for (serviceInstance in instances!!) {
            html += "<h3>Instance: " + serviceInstance.getUri() + "</h3>"
            html += "Host: " + serviceInstance.getHost() + "<br>"
            html += "Port: " + serviceInstance.getPort() + "<br>"
        }

        return html
    }

    // A REST method, To call from another service.
    // See in Lesson "Load Balancing with Ribbon".
    @ResponseBody
    @RequestMapping(value = "/hello", method = arrayOf(RequestMethod.GET))
    fun hello(): String {
        return "<html>Hello from ABC-SERVICE</html>"
    }
}
