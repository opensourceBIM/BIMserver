package org.bimserver.tests.ifc;

import org.bimserver.interfaces.objects.SActionState;
import org.bimserver.interfaces.objects.SDeserializerPluginConfiguration;
import org.bimserver.interfaces.objects.SLongActionState;
import org.bimserver.interfaces.objects.SProject;
import org.bimserver.plugins.services.BimServerClientInterface;
import org.bimserver.shared.ChannelConnectionException;
import org.bimserver.shared.UsernamePasswordAuthenticationInfo;
import org.bimserver.shared.exceptions.ServiceException;
import org.bimserver.tests.TestWithEmbeddedServer;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class TestIfc4x3 extends TestWithEmbeddedServer {
    private final String testFileLocation = "https://github.com/buildingSMART/IFC4.3.x-sample-models/raw/main/models/";
    private final String[] testFiles = {
        "advanced-geometric-shape/basin-advanced-brep/basin-advanced-brep.ifc",
        "advanced-geometric-shape/basin-faceted-brep/basin-faceted-brep.ifc",
        "advanced-geometric-shape/basin-tessellation/basin-tessellation.ifc",
        "advanced-geometric-shape/bath-csg-solid/bath-csg-solid.ifc",
        "advanced-geometric-shape/cube-advanced-brep/cube-advanced-brep.ifc",
        "alignment-geometries-and-linear-positioning/fixed-reference-swept-area-solid/fixed-reference-swept-area-solid.ifc",
        "alignment-geometries-and-linear-positioning/linear-placement-of-signal/linear-placement-of-signal.ifc",
        "alignment-geometries-and-linear-positioning/sectioned-solid-horizontal/sectioned-solid-horizontal.ifc",
        "basic-geometric-shape/brep-model/brep-model.ifc",
        "basic-geometric-shape/csg-primitive/csg-primitive.ifc",
        "basic-geometric-shape/extruded-solid/extruded-solid.ifc",
        "basic-geometric-shape/surface-model/surface-model.ifc",
        "basic-geometric-shape/triangulated-item/triangulated-item.ifc",
        "building-elements/beam-extruded-solid/beam-extruded-solid.ifc",
        "building-elements/beam-parametric-cross-section/beam-parametric-cross-section.ifc",
        "building-elements/beam-revolved-solid/beam-revolved-solid.ifc",
        "building-elements/beam-varying-cardinal-points/beam-varying-cardinal-points.ifc",
        "building-elements/beam-varying-extrusion-paths/beam-varying-extrusion-paths.ifc",
        "building-elements/beam-varying-profiles/beam-varying-profiles.ifc",
        "building-elements/column-extruded-solid/column-extruded-solid.ifc",
        "building-elements/reinforcing-assembly/reinforcing-assembly.ifc",
        "building-elements/reinforcing-stirrup/reinforcing-stirrup.ifc",
        "building-elements/slab-extrusion/slab-extruded-solid.ifc",
        "building-elements/slab-openings/slab-openings.ifc",
        "building-elements/wall-extrusion/wall-extruded-solid.ifc",
        "construction-scheduling/construction-scheduling-task/construction-scheduling-task.ifc",
        "mapped-geometric-shape/mapped-shape-with-multiple-items/mapped-shape-with-multiple-items.ifc",
        "mapped-geometric-shape/mapped-shape-without-transformation/mapped-shape-without-transformation.ifc",
        "mapped-geometric-shape/mapped-shape-with-transformation/mapped-shape-with-transformation.ifc",
        "placements-and-gis-referencing/geographic-referencing-gk/geographic-referencing-gk.ifc",
        "placements-and-gis-referencing/geographic-referencing-rigid-operation/geographic-referencing-rigid-operation.ifc",
        "placements-and-gis-referencing/geographic-referencing-utm/geographic-referencing-utm.ifc",
        "placements-and-gis-referencing/grid-placement/grid-placement.ifc",
        "structural-analysis-model/structural-curve-member/structural-curve-member.ifc",
        "tessellated-shape/beam-curved-i-shape-tessellated/beam-curved-i-shape-tessellated.ifc",
        "tessellated-shape/beam-straight-i-shape-tessellated/beam-straight-i-shape-tessellated.ifc",
        "tessellated-shape/column-straight-rectangle-tessellation/column-straight-rectangle-tessellation.ifc",
        "tessellated-shape/polygonal-face-tessellation/polygonal-face-tessellation.ifc",
        "tessellated-shape/slab-tessellated-unique-vertices/slab-tessellated-unique-vertices.ifc",
        "tessellated-shape-with-style/tessellation-with-blob-texture/tessellation-with-blob-texture.ifc",
        "tessellated-shape-with-style/tessellation-with-image-texture/tessellation-with-image-texture.ifc",
        "tessellated-shape-with-style/tessellation-with-individual-colors/tessellation-with-individual-colors.ifc",
        "tessellated-shape-with-style/tessellation-with-pixel-texture/tessellation-with-pixel-texture.ifc",
        "trimmed-curve-parameters/curve-parameters-in-degrees/curve-parameters-in-degrees.ifc",
        "trimmed-curve-parameters/curve-parameters-in-radians/curve-parameters-in-radians.ifc"
    };
    @Test
    public void testCheckin() throws ServiceException, ChannelConnectionException, MalformedURLException, URISyntaxException {
        BimServerClientInterface bimServerClient = getFactory().create(new UsernamePasswordAuthenticationInfo("admin@bimserver.org", "admin"));
        for(String testFile: testFiles) {
            SProject newProject = bimServerClient.getServiceInterface().addProject(testFile.substring(testFile.lastIndexOf("/")+1), "ifc4");
            SDeserializerPluginConfiguration deserializer = bimServerClient.getServiceInterface().getSuggestedDeserializerForExtension("ifc", newProject.getOid());
            SLongActionState longActionState = bimServerClient.checkinSync(newProject.getOid(), "test", deserializer.getOid(), false, new URI(testFileLocation + testFile).toURL());
            Assertions.assertEquals(SActionState.FINISHED, longActionState.getState());
            Assertions.assertEquals(0, longActionState.getErrors().size());
        }
    }
}
