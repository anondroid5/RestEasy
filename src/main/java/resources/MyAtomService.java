package resources;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Date;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jboss.resteasy.plugins.providers.atom.Feed;
import org.jboss.resteasy.plugins.providers.atom.Content;
import org.jboss.resteasy.plugins.providers.atom.Entry;
import org.jboss.resteasy.plugins.providers.atom.Link;
import org.jboss.resteasy.plugins.providers.atom.Person;

@Path("atom")
public class MyAtomService {
	
	@GET
	@Path("feed")
	@Produces("application/atom+xml")
	public Feed getFeed() throws URISyntaxException{
		Feed feed = new Feed();
		feed.setId(new URI("http://example.com/42"));
		feed.setTitle("My Feed");
		feed.setUpdated(new Date());
		Link link = new Link();
		link.setHref(new URI("http://localhost"));
		link.setRel("edit");
		feed.getLinks().add(link);
		feed.getAuthors().add(new Person("Bill Burke"));
		Entry entry = new Entry();
		entry.setTitle("Hello World");
		Content content = new Content();
		content.setType(MediaType.TEXT_HTML_TYPE);
		content.setText("Nothing much");
		entry.setContent(content);
		feed.getEntries().add(entry);
		return feed;
	}
}
