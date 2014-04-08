package eu.apachecon.camel.cdi.demo1;

import static org.junit.Assert.assertEquals;

import javax.inject.Inject;

import org.apache.camel.ProducerTemplate;
import org.apache.camel.cdi.Uri;
import org.apache.camel.cdi.internal.CamelExtension;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import eu.apachecon.camel.cdi.demo1.svc.Service;

@RunWith(Arquillian.class)
public class CdiDeploymentTest {

    @Inject @Uri(value = "seda:foo", context = "first")
    ProducerTemplate producer;

    @Test
	public void testSend() {
		Object response = producer.requestBody("direct:serviceCall", "Mark");

		assertEquals("Hey Mark", response);
	}

	@Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
            .addPackage(CamelExtension.class.getPackage())
            .addPackage(SimpleRouteBuilder.class.getPackage())
            .addPackage(Service.class.getPackage())
            .addAsManifestResource("META-INF/beans.xml", "beans.xml")
        	.addAsManifestResource(EmptyAsset.INSTANCE, "ejb-jar.xml");
    }
}
