package org.bimserver.emf;

import org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package;
import org.bimserver.models.ifc4.Ifc4Package;
import org.bimserver.models.ifc4x3.Ifc4x3Package;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;


public class Mismatches {
    private static final Logger LOGGER = LoggerFactory.getLogger(Mismatches.class);
    private static final Map<EPackage, Mismatches> mismatchCache = new HashMap<>();

    private final Map<EReference, EReference[]> forwardToInverse = new HashMap<>();
    private final Map<EReference, EReference> inverseToForward = new HashMap<>();

    private Mismatches() {
    }
    public EReference[] getInverse(EReference forward){
        return forwardToInverse.get(forward);
    }
    public EReference getForward(EReference inverse){
        return inverseToForward.get(inverse);
    }
    public Set<EReference> getForward(){
        return forwardToInverse.keySet();
    }
    private static Mismatches of(Mismatch... matches){
        Mismatches mismatches = new Mismatches();
        for(Mismatch match: matches){
            mismatches.forwardToInverse.put(match.forward, match.inverse);
            for (EReference inverse: match.inverse){
                if(mismatches.inverseToForward.containsKey(inverse)){
                    // assert all inverses unique in mismatches - key does not exist in inverseToForward
                    LOGGER.error("Found unexpected N:M inverse: " + inverse.getName() + " for " + mismatches.inverseToForward.get(inverse).getName() + " and " + match.forward.getName());
                }
                mismatches.inverseToForward.put(inverse, match.forward);
            }
        }
        return mismatches;
    }

    public static Mismatches forSchema(Schema schema){
        if(!Schema.getIfcSchemas().contains(schema)){
            LOGGER.error("Schema mismatches only applicable for IFC schemas, called for schema " + schema.name());
        }
        return forPackage(schema.getEPackage());
    }

    public static Mismatches forPackage(EPackage ePackage) {
        return mismatchCache.getOrDefault(ePackage, new Mismatches());
    }

    static {
        /*
         * This has been implemented manually, but with the assistance of the output of Express2Emf (which dumps all the mismatched inverses in the schema).
         * Code has been updated for IFC4_ADD2
         */
        Ifc4Package ifc4 = Ifc4Package.eINSTANCE;
        Ifc4x3Package ifc4x3 = Ifc4x3Package.eINSTANCE;
        Ifc2x3tc1Package ifc2x3 = Ifc2x3tc1Package.eINSTANCE;
        mismatchCache.put( ifc2x3, Mismatches.of(
            new Mismatch(ifc2x3.getIfcRelContainedInSpatialStructure_RelatedElements(), new EReference[]{
                    ifc2x3.getIfcElement_ContainedInStructure(),
                    ifc2x3.getIfcGrid_ContainedInStructure(),
                    ifc2x3.getIfcAnnotation_ContainedInStructure()}),
            new Mismatch(ifc2x3.getIfcPresentationLayerAssignment_AssignedItems(), new EReference[]{
                    ifc2x3.getIfcRepresentation_LayerAssignments(),
                    ifc2x3.getIfcRepresentationItem_LayerAssignments() }),
            new Mismatch(ifc2x3.getIfcRelAssociates_RelatedObjects(), new EReference[]{
                    ifc2x3.getIfcObjectDefinition_HasAssociations(),
                    ifc2x3.getIfcPropertyDefinition_HasAssociations() }),
            new Mismatch(ifc2x3.getIfcTerminatorSymbol_AnnotatedCurve(), new EReference[]{
                    ifc2x3.getIfcDimensionCurve_AnnotatedBySymbols() }),
            new Mismatch(ifc2x3.getIfcRelReferencedInSpatialStructure_RelatedElements(), new EReference[]{
                    ifc2x3.getIfcElement_ReferencedInStructures() }),
            new Mismatch(ifc2x3.getIfcProduct_Representation(), new EReference[]{
                    ifc2x3.getIfcProductDefinitionShape_ShapeOfProduct() }),
            new Mismatch(ifc2x3.getIfcRelConnectsElements_RelatingElement(), new EReference[]{
                    ifc2x3.getIfcStructuralItem_AssignedStructuralActivity()})
        ));
        mismatchCache.put(ifc4, Mismatches.of(
            new Mismatch(ifc4.getIfcClassificationReference_ReferencedSource(),new EReference[]{
                    ifc4.getIfcClassification_HasReferences(),
                    ifc4.getIfcClassificationReference_HasReferences()
            }),
            new Mismatch(ifc4.getIfcCoordinateOperation_SourceCRS(),new EReference[]{
                    ifc4.getIfcCoordinateReferenceSystem_HasCoordinateOperation(),
                    ifc4.getIfcGeometricRepresentationContext_HasCoordinateOperation()
            }),
            new Mismatch(ifc4.getIfcExternalReferenceRelationship_RelatedResourceObjects(), new EReference[]{
                    ifc4.getIfcActorRole_HasExternalReference(),
                    ifc4.getIfcAppliedValue_HasExternalReference(),
                    ifc4.getIfcApproval_HasExternalReferences(),
                    ifc4.getIfcConstraint_HasExternalReferences(),
                    ifc4.getIfcContextDependentUnit_HasExternalReference(),
                    ifc4.getIfcConversionBasedUnit_HasExternalReference(),
                    ifc4.getIfcMaterialDefinition_HasExternalReferences(),
                    ifc4.getIfcPhysicalQuantity_HasExternalReferences(),
                    ifc4.getIfcProfileDef_HasExternalReference(),
                    ifc4.getIfcPropertyAbstraction_HasExternalReferences(),
                    ifc4.getIfcTimeSeries_HasExternalReference()
            }),
            new Mismatch(ifc4.getIfcPresentationLayerAssignment_AssignedItems(), new EReference[]{
                    ifc4.getIfcRepresentation_LayerAssignments(),
                    ifc4.getIfcRepresentationItem_LayerAssignment() }),
            new Mismatch(ifc4.getIfcProduct_Representation(), new EReference[]{
                    ifc4.getIfcProductDefinitionShape_ShapeOfProduct() }),
            new Mismatch(ifc4.getIfcRelAssignsToProcess_RelatingProcess(),new EReference[]{
                    ifc4.getIfcProcess_OperatesOn(),
                    ifc4.getIfcTypeProcess_OperatesOn()
            }),
            new Mismatch(ifc4.getIfcRelAssignsToProduct_RelatingProduct(),new EReference[]{
                    ifc4.getIfcProduct_ReferencedBy(),
                    ifc4.getIfcTypeProduct_ReferencedBy() // previously missing
            }),
            new Mismatch(ifc4.getIfcRelAssignsToResource_RelatingResource(),new EReference[]{
                    ifc4.getIfcResource_ResourceOf(),
                    ifc4.getIfcTypeResource_ResourceOf()
            }),
            new Mismatch(ifc4.getIfcRelAssociates_RelatedObjects(), new EReference[]{
                    ifc4.getIfcObjectDefinition_HasAssociations(),
                    ifc4.getIfcPropertyDefinition_HasAssociations() }),
            new Mismatch(ifc4.getIfcRelAssociatesClassification_RelatingClassification(), new EReference[]{
                    ifc4.getIfcClassification_ClassificationForObjects(),
                    ifc4.getIfcClassificationReference_ClassificationRefForObjects()
            }),
            new Mismatch(ifc4.getIfcRelAssociatesDocument_RelatingDocument(),new EReference[]{
                    ifc4.getIfcDocumentInformation_DocumentInfoForObjects(),
                    ifc4.getIfcDocumentReference_DocumentRefForObjects()
            }),
            new Mismatch(ifc4.getIfcRelAssociatesLibrary_RelatingLibrary(),new EReference[]{
                    ifc4.getIfcLibraryInformation_LibraryInfoForObjects(),
                    ifc4.getIfcLibraryReference_LibraryRefForObjects()
            }),
            new Mismatch(ifc4.getIfcRelAssociatesMaterial_RelatingMaterial(),new EReference[]{
                    ifc4.getIfcMaterialDefinition_AssociatedTo(),
                    ifc4.getIfcMaterialUsageDefinition_AssociatedTo()
            }),
            new Mismatch(ifc4.getIfcRelConnectsStructuralActivity_RelatingElement(), new EReference[]{ // previously wrong (IfcRelConnectsElements)
                    ifc4.getIfcStructuralItem_AssignedStructuralActivity()}),
            new Mismatch(ifc4.getIfcRelContainedInSpatialStructure_RelatedElements(), new EReference[]{
                    ifc4.getIfcElement_ContainedInStructure(),
                    ifc4.getIfcGrid_ContainedInStructure(),
                    ifc4.getIfcAnnotation_ContainedInStructure()}),
            new Mismatch(ifc4.getIfcRelDeclares_RelatedDefinitions(),new EReference[]{
                    ifc4.getIfcObjectDefinition_HasContext(),
                    ifc4.getIfcPropertyDefinition_HasContext()
            }),
            new Mismatch(ifc4.getIfcRelDefinesByProperties_RelatedObjects(),new EReference[]{
                    ifc4.getIfcContext_IsDefinedBy(),
                    ifc4.getIfcObject_IsDefinedBy()
            }),
            new Mismatch(ifc4.getIfcRelDefinesByProperties_RelatingPropertyDefinition(),new EReference[]{
                    ifc4.getIfcPropertySetDefinition_DefinesOccurrence()
            }),
            new Mismatch(ifc4.getIfcRelReferencedInSpatialStructure_RelatedElements(), new EReference[]{
                    ifc4.getIfcElement_ReferencedInStructures()
            }),
            new Mismatch(ifc4.getIfcRelSpaceBoundary_RelatingSpace(),new EReference[]{
                    ifc4.getIfcExternalSpatialElement_BoundedBy(),
                    ifc4.getIfcSpace_BoundedBy()
            }),
            new Mismatch(ifc4.getIfcResourceApprovalRelationship_RelatedResourceObjects(),new EReference[]{
                    ifc4.getIfcProperty_HasApprovals()
            }),
            new Mismatch(ifc4.getIfcResourceConstraintRelationship_RelatedResourceObjects(),new EReference[]{
                    ifc4.getIfcProperty_HasConstraints()
            }),
            new Mismatch(ifc4.getIfcShapeAspect_PartOfProductDefinitionShape(),new EReference[]{
                    ifc4.getIfcProductDefinitionShape_HasShapeAspects(),
                    ifc4.getIfcRepresentationMap_HasShapeAspects()
            })

            // Removed in IFC4 _after_ IFC4-final
            // IfcRelAssignsToProcess_RelatingProcess -> IfcProduct_ReferencedBy
            // IfcRelAssignsToProcess_RelatingProcess -> IfcTypeProduct_ReferencedBy

            // New in IFC4 _after_ IFC4-final
            // IfcCoordinateOperation_SourceCRS -> IfcCoordinateReferenceSystem_HasCoordinateOperation();
            // IfcCoordinateOperation_SourceCRS   -> IfcGeometricRepresentationContext_HasCoordinateOperation();
            // IfcRelAssignsToProduct_RelatingProduct -> IfcProduct_ReferencedBy
            // IfcRelAssignsToProduct_RelatingProduct -> IfcTypeProduct_ReferencedBy
            // IfcResourceConstraintRelationship_RelatedResourceObjects -> IfcProperty_HasConstraints
            // IfcResourceApprovalRelationship_RelatedResourceObjects -> IfcProperty_HasApprovals
        ));

        mismatchCache.put(ifc4x3, Mismatches.of(
            new Mismatch(ifc4x3.getIfcClassificationReference_ReferencedSource(),new EReference[]{
                    ifc4x3.getIfcClassification_HasReferences(),
                    ifc4x3.getIfcClassificationReference_HasReferences()
            }),
            new Mismatch(ifc4x3.getIfcCoordinateOperation_SourceCRS(),new EReference[]{
                    ifc4x3.getIfcCoordinateReferenceSystem_HasCoordinateOperation(),
                    ifc4x3.getIfcGeometricRepresentationContext_HasCoordinateOperation()
            }),
            new Mismatch(ifc4x3.getIfcExternalReferenceRelationship_RelatedResourceObjects(), new EReference[]{
                    ifc4x3.getIfcActorRole_HasExternalReference(),
                    ifc4x3.getIfcAppliedValue_HasExternalReference(),
                    ifc4x3.getIfcApproval_HasExternalReferences(),
                    ifc4x3.getIfcConstraint_HasExternalReferences(),
                    ifc4x3.getIfcContextDependentUnit_HasExternalReference(),
                    ifc4x3.getIfcConversionBasedUnit_HasExternalReference(),
                    ifc4x3.getIfcMaterialDefinition_HasExternalReferences(),
                    ifc4x3.getIfcPhysicalQuantity_HasExternalReferences(),
                    ifc4x3.getIfcProfileDef_HasExternalReference(),
                    ifc4x3.getIfcPropertyAbstraction_HasExternalReferences(),
                    ifc4x3.getIfcShapeAspect_HasExternalReferences(),  // new in IFC4x3
                    ifc4x3.getIfcTimeSeries_HasExternalReference()
            }),
            new Mismatch(ifc4x3.getIfcPresentationLayerAssignment_AssignedItems(), new EReference[]{
                    ifc4x3.getIfcRepresentation_LayerAssignments(),
                    ifc4x3.getIfcRepresentationItem_LayerAssignment() }),
            new Mismatch(ifc4x3.getIfcProduct_Representation(), new EReference[]{
                    ifc4x3.getIfcProductDefinitionShape_ShapeOfProduct() }),
            new Mismatch(ifc4x3.getIfcRelAssignsToProcess_RelatingProcess(),new EReference[]{
                    ifc4x3.getIfcProcess_OperatesOn(),
                    ifc4x3.getIfcTypeProcess_OperatesOn()
            }),
            new Mismatch(ifc4x3.getIfcRelAssignsToProduct_RelatingProduct(),new EReference[]{
                    ifc4x3.getIfcProduct_ReferencedBy(),
                    ifc4x3.getIfcTypeProduct_ReferencedBy()
            }),
            new Mismatch(ifc4x3.getIfcRelAssignsToResource_RelatingResource(),new EReference[]{
                    ifc4x3.getIfcResource_ResourceOf(),
                    ifc4x3.getIfcTypeResource_ResourceOf()
            }),
            new Mismatch(ifc4x3.getIfcRelAssociates_RelatedObjects(), new EReference[]{
                    ifc4x3.getIfcObjectDefinition_HasAssociations(),
                    ifc4x3.getIfcPropertyDefinition_HasAssociations() }),
            new Mismatch(ifc4x3.getIfcRelAssociatesClassification_RelatingClassification(), new EReference[]{
                    ifc4x3.getIfcClassification_ClassificationForObjects(),
                    ifc4x3.getIfcClassificationReference_ClassificationRefForObjects()
            }),
            new Mismatch(ifc4x3.getIfcRelAssociatesDocument_RelatingDocument(),new EReference[]{
                    ifc4x3.getIfcDocumentInformation_DocumentInfoForObjects(),
                    ifc4x3.getIfcDocumentReference_DocumentRefForObjects()
            }),
            new Mismatch(ifc4x3.getIfcRelAssociatesLibrary_RelatingLibrary(),new EReference[]{
                    ifc4x3.getIfcLibraryInformation_LibraryInfoForObjects(),
                    ifc4x3.getIfcLibraryReference_LibraryRefForObjects()
            }),
            new Mismatch(ifc4x3.getIfcRelAssociatesMaterial_RelatingMaterial(),new EReference[]{
                    ifc4x3.getIfcMaterialDefinition_AssociatedTo(),
                    ifc4x3.getIfcMaterialUsageDefinition_AssociatedTo()
            }),
            new Mismatch(ifc4x3.getIfcRelConnectsStructuralActivity_RelatingElement(), new EReference[]{
                    ifc4x3.getIfcStructuralItem_AssignedStructuralActivity()}),
            new Mismatch(ifc4x3.getIfcRelContainedInSpatialStructure_RelatedElements(), new EReference[]{
                    ifc4x3.getIfcElement_ContainedInStructure(),
                    ifc4x3.getIfcPositioningElement_ContainedInStructure(),  // changed in IFC4x3
                    ifc4x3.getIfcAnnotation_ContainedInStructure()}),
            new Mismatch(ifc4x3.getIfcRelDeclares_RelatedDefinitions(),new EReference[]{
                    ifc4x3.getIfcObjectDefinition_HasContext(),
                    ifc4x3.getIfcPropertyDefinition_HasContext()
            }),
            new Mismatch(ifc4x3.getIfcRelDefinesByProperties_RelatedObjects(),new EReference[]{
                    ifc4x3.getIfcContext_IsDefinedBy(),
                    ifc4x3.getIfcObject_IsDefinedBy()
            }),
            new Mismatch(ifc4x3.getIfcRelDefinesByProperties_RelatingPropertyDefinition(),new EReference[]{
                    ifc4x3.getIfcPropertySetDefinition_DefinesOccurrence()
            }),
            new Mismatch(ifc4x3.getIfcRelInterferesElements_RelatedElement(), new EReference[]{  // new in IFC4x3
                    ifc4x3.getIfcElement_IsInterferedByElements(),
                    ifc4x3.getIfcSpatialElement_IsInterferedByElements()
            }),
            new Mismatch(ifc4x3.getIfcRelInterferesElements_RelatingElement(), new EReference[]{ // new in IFC4x3
                    ifc4x3.getIfcElement_InterferesElements(),
                    ifc4x3.getIfcSpatialElement_InterferesElements()
            }),
            new Mismatch(ifc4x3.getIfcRelReferencedInSpatialStructure_RelatedElements(), new EReference[]{  // limited in IFC4x3
                    ifc4x3.getIfcGroup_ReferencedInStructures(),
                    ifc4x3.getIfcProduct_ReferencedInStructures(),
                    ifc4x3.getIfcSystem_ServicesFacilities()
            }),
            new Mismatch(ifc4x3.getIfcRelSpaceBoundary_RelatingSpace(),new EReference[]{
                    ifc4x3.getIfcExternalSpatialElement_BoundedBy(),
                    ifc4x3.getIfcSpace_BoundedBy()
            }),
            new Mismatch(ifc4x3.getIfcResourceApprovalRelationship_RelatedResourceObjects(),new EReference[]{
                    ifc4x3.getIfcProperty_HasApprovals()
            }),
            new Mismatch(ifc4x3.getIfcResourceConstraintRelationship_RelatedResourceObjects(),new EReference[]{
                    ifc4x3.getIfcProperty_HasConstraints()
            }),
            new Mismatch(ifc4x3.getIfcShapeAspect_PartOfProductDefinitionShape(),new EReference[]{
                    ifc4x3.getIfcProductDefinitionShape_HasShapeAspects(),
                    ifc4x3.getIfcRepresentationMap_HasShapeAspects()
            })
        ));
    }

    public static class Mismatch {
        EReference forward;
        EReference[] inverse;
        Mismatch(EReference forward, EReference[] inverse){
            this.forward = forward;
            this.inverse = inverse;
        }
    }
}
