package uk.ac.ebi.pride.ws.pride.hateoas;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.hateoas.PagedResources;
import org.springframework.hateoas.ResourceSupport;

import java.util.Collection;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

/**
 * @author ypriverol
 */
public class FacetPagedResource<T> extends PagedResources<T> {

    private Map<String, Collection<ResourceSupport>> facets = new TreeMap<>();

    public FacetPagedResource(PagedResources<T> pagedResources, Map<String, Collection<ResourceSupport>> facets) {
        super(pagedResources.getContent(), pagedResources.getMetadata(), pagedResources.getLinks());
        this.facets = facets;
    }

    @JsonProperty("_facets")
    public Map<String, Collection<ResourceSupport>> getFacets() {
        return facets;
    }

    @JsonProperty("_highlights")
    public Map<String, Collection<ResourceSupport>> getHighlights() {
        return facets;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        FacetPagedResource<?> that = (FacetPagedResource<?>) o;
        return Objects.equals(facets, that.facets);
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), facets);
    }
}
