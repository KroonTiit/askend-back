package filter;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import com.example.askend.FilterController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

@Component
public
class FilterModelAssembler implements RepresentationModelAssembler<Filter, EntityModel<Filter>> {

    @Autowired
    public FilterModelAssembler() {
        super();
    }
    @Override
    public EntityModel<Filter> toModel(Filter employee) {

        return EntityModel.of(employee, //
                linkTo(methodOn(FilterController.class).one(employee.getId())).withSelfRel(),
                linkTo(methodOn(FilterController.class).all()).withRel("employees"));
    }
}