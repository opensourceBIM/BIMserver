{
  "classes" : {
    "Tristate" : { },
    "Ifc2DCompositeCurve" : {
      "domain" : null,
      "superclasses" : [ "IfcCompositeCurve" ],
      "fields" : { }
    },
    "IfcActionRequest" : {
      "domain" : null,
      "superclasses" : [ "IfcControl" ],
      "fields" : {
        "RequestID" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcActor" : {
      "domain" : null,
      "superclasses" : [ "IfcObject" ],
      "fields" : {
        "TheActor" : {
          "type" : "IfcActorSelect",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "IsActingUpon" : {
          "type" : "IfcRelAssignsToActor",
          "reference" : true,
          "many" : true,
          "inverse" : true
        }
      }
    },
    "IfcActorRole" : {
      "domain" : null,
      "superclasses" : [ ],
      "fields" : {
        "Role" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "UserDefinedRole" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "Description" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcActuatorType" : {
      "domain" : null,
      "superclasses" : [ "IfcDistributionControlElementType" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcAddress" : {
      "domain" : null,
      "superclasses" : [ "IfcObjectReferenceSelect" ],
      "fields" : {
        "Purpose" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "Description" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "UserDefinedPurpose" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "OfPerson" : {
          "type" : "IfcPerson",
          "reference" : true,
          "many" : true,
          "inverse" : true
        },
        "OfOrganization" : {
          "type" : "IfcOrganization",
          "reference" : true,
          "many" : true,
          "inverse" : true
        }
      }
    },
    "IfcAirTerminalBoxType" : {
      "domain" : null,
      "superclasses" : [ "IfcFlowControllerType" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcAirTerminalType" : {
      "domain" : null,
      "superclasses" : [ "IfcFlowTerminalType" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcAirToAirHeatRecoveryType" : {
      "domain" : null,
      "superclasses" : [ "IfcEnergyConversionDeviceType" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcAlarmType" : {
      "domain" : null,
      "superclasses" : [ "IfcDistributionControlElementType" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcAngularDimension" : {
      "domain" : null,
      "superclasses" : [ "IfcDimensionCurveDirectedCallout" ],
      "fields" : { }
    },
    "IfcAnnotation" : {
      "domain" : null,
      "superclasses" : [ "IfcProduct" ],
      "fields" : {
        "ContainedInStructure" : {
          "type" : "IfcRelContainedInSpatialStructure",
          "reference" : true,
          "many" : true,
          "inverse" : true
        }
      }
    },
    "IfcAnnotationCurveOccurrence" : {
      "domain" : null,
      "superclasses" : [ "IfcAnnotationOccurrence", "IfcDraughtingCalloutElement" ],
      "fields" : { }
    },
    "IfcAnnotationFillArea" : {
      "domain" : null,
      "superclasses" : [ "IfcGeometricRepresentationItem" ],
      "fields" : {
        "OuterBoundary" : {
          "type" : "IfcCurve",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "InnerBoundaries" : {
          "type" : "IfcCurve",
          "reference" : true,
          "many" : true,
          "inverse" : false
        }
      }
    },
    "IfcAnnotationFillAreaOccurrence" : {
      "domain" : null,
      "superclasses" : [ "IfcAnnotationOccurrence" ],
      "fields" : {
        "FillStyleTarget" : {
          "type" : "IfcPoint",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "GlobalOrLocal" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcAnnotationOccurrence" : {
      "domain" : null,
      "superclasses" : [ "IfcStyledItem" ],
      "fields" : { }
    },
    "IfcAnnotationSurface" : {
      "domain" : null,
      "superclasses" : [ "IfcGeometricRepresentationItem" ],
      "fields" : {
        "Item" : {
          "type" : "IfcGeometricRepresentationItem",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "TextureCoordinates" : {
          "type" : "IfcTextureCoordinate",
          "reference" : true,
          "many" : false,
          "inverse" : true
        }
      }
    },
    "IfcAnnotationSurfaceOccurrence" : {
      "domain" : null,
      "superclasses" : [ "IfcAnnotationOccurrence" ],
      "fields" : { }
    },
    "IfcAnnotationSymbolOccurrence" : {
      "domain" : null,
      "superclasses" : [ "IfcAnnotationOccurrence", "IfcDraughtingCalloutElement" ],
      "fields" : { }
    },
    "IfcAnnotationTextOccurrence" : {
      "domain" : null,
      "superclasses" : [ "IfcAnnotationOccurrence", "IfcDraughtingCalloutElement" ],
      "fields" : { }
    },
    "IfcApplication" : {
      "domain" : null,
      "superclasses" : [ ],
      "fields" : {
        "ApplicationDeveloper" : {
          "type" : "IfcOrganization",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "Version" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "ApplicationFullName" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "ApplicationIdentifier" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcAppliedValue" : {
      "domain" : null,
      "superclasses" : [ "IfcObjectReferenceSelect" ],
      "fields" : {
        "Name" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "Description" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "AppliedValue" : {
          "type" : "IfcAppliedValueSelect",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "UnitBasis" : {
          "type" : "IfcMeasureWithUnit",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "ApplicableDate" : {
          "type" : "IfcDateTimeSelect",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "FixedUntilDate" : {
          "type" : "IfcDateTimeSelect",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "ValuesReferenced" : {
          "type" : "IfcReferencesValueDocument",
          "reference" : true,
          "many" : true,
          "inverse" : true
        },
        "ValueOfComponents" : {
          "type" : "IfcAppliedValueRelationship",
          "reference" : true,
          "many" : true,
          "inverse" : true
        },
        "IsComponentIn" : {
          "type" : "IfcAppliedValueRelationship",
          "reference" : true,
          "many" : true,
          "inverse" : true
        }
      }
    },
    "IfcAppliedValueRelationship" : {
      "domain" : null,
      "superclasses" : [ ],
      "fields" : {
        "ComponentOfTotal" : {
          "type" : "IfcAppliedValue",
          "reference" : true,
          "many" : false,
          "inverse" : true
        },
        "Components" : {
          "type" : "IfcAppliedValue",
          "reference" : true,
          "many" : true,
          "inverse" : true
        },
        "ArithmeticOperator" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "Name" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "Description" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcApproval" : {
      "domain" : null,
      "superclasses" : [ ],
      "fields" : {
        "Description" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "ApprovalDateTime" : {
          "type" : "IfcDateTimeSelect",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "ApprovalStatus" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "ApprovalLevel" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "ApprovalQualifier" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "Name" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "Identifier" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "Actors" : {
          "type" : "IfcApprovalActorRelationship",
          "reference" : true,
          "many" : true,
          "inverse" : true
        },
        "IsRelatedWith" : {
          "type" : "IfcApprovalRelationship",
          "reference" : true,
          "many" : true,
          "inverse" : true
        },
        "Relates" : {
          "type" : "IfcApprovalRelationship",
          "reference" : true,
          "many" : true,
          "inverse" : true
        }
      }
    },
    "IfcApprovalActorRelationship" : {
      "domain" : null,
      "superclasses" : [ ],
      "fields" : {
        "Actor" : {
          "type" : "IfcActorSelect",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "Approval" : {
          "type" : "IfcApproval",
          "reference" : true,
          "many" : false,
          "inverse" : true
        },
        "Role" : {
          "type" : "IfcActorRole",
          "reference" : true,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcApprovalPropertyRelationship" : {
      "domain" : null,
      "superclasses" : [ ],
      "fields" : {
        "ApprovedProperties" : {
          "type" : "IfcProperty",
          "reference" : true,
          "many" : true,
          "inverse" : false
        },
        "Approval" : {
          "type" : "IfcApproval",
          "reference" : true,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcApprovalRelationship" : {
      "domain" : null,
      "superclasses" : [ ],
      "fields" : {
        "RelatedApproval" : {
          "type" : "IfcApproval",
          "reference" : true,
          "many" : false,
          "inverse" : true
        },
        "RelatingApproval" : {
          "type" : "IfcApproval",
          "reference" : true,
          "many" : false,
          "inverse" : true
        },
        "Description" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "Name" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcArbitraryClosedProfileDef" : {
      "domain" : null,
      "superclasses" : [ "IfcProfileDef" ],
      "fields" : {
        "OuterCurve" : {
          "type" : "IfcCurve",
          "reference" : true,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcArbitraryOpenProfileDef" : {
      "domain" : null,
      "superclasses" : [ "IfcProfileDef" ],
      "fields" : {
        "Curve" : {
          "type" : "IfcBoundedCurve",
          "reference" : true,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcArbitraryProfileDefWithVoids" : {
      "domain" : null,
      "superclasses" : [ "IfcArbitraryClosedProfileDef" ],
      "fields" : {
        "InnerCurves" : {
          "type" : "IfcCurve",
          "reference" : true,
          "many" : true,
          "inverse" : false
        }
      }
    },
    "IfcAsset" : {
      "domain" : null,
      "superclasses" : [ "IfcGroup" ],
      "fields" : {
        "AssetID" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "OriginalValue" : {
          "type" : "IfcCostValue",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "CurrentValue" : {
          "type" : "IfcCostValue",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "TotalReplacementCost" : {
          "type" : "IfcCostValue",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "Owner" : {
          "type" : "IfcActorSelect",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "User" : {
          "type" : "IfcActorSelect",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "ResponsiblePerson" : {
          "type" : "IfcPerson",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "IncorporationDate" : {
          "type" : "IfcCalendarDate",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "DepreciatedValue" : {
          "type" : "IfcCostValue",
          "reference" : true,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcAsymmetricIShapeProfileDef" : {
      "domain" : null,
      "superclasses" : [ "IfcIShapeProfileDef" ],
      "fields" : {
        "TopFlangeWidth" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "TopFlangeWidthAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "TopFlangeThickness" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "TopFlangeThicknessAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "TopFlangeFilletRadius" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "TopFlangeFilletRadiusAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "CentreOfGravityInY" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "CentreOfGravityInYAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcAxis1Placement" : {
      "domain" : null,
      "superclasses" : [ "IfcPlacement" ],
      "fields" : {
        "Axis" : {
          "type" : "IfcDirection",
          "reference" : true,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcAxis2Placement2D" : {
      "domain" : null,
      "superclasses" : [ "IfcPlacement", "IfcAxis2Placement" ],
      "fields" : {
        "RefDirection" : {
          "type" : "IfcDirection",
          "reference" : true,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcAxis2Placement3D" : {
      "domain" : null,
      "superclasses" : [ "IfcPlacement", "IfcAxis2Placement" ],
      "fields" : {
        "Axis" : {
          "type" : "IfcDirection",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "RefDirection" : {
          "type" : "IfcDirection",
          "reference" : true,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcBSplineCurve" : {
      "domain" : null,
      "superclasses" : [ "IfcBoundedCurve" ],
      "fields" : {
        "Degree" : {
          "type" : "long",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "ControlPointsList" : {
          "type" : "IfcCartesianPoint",
          "reference" : true,
          "many" : true,
          "inverse" : false
        },
        "CurveForm" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "ClosedCurve" : {
          "type" : "boolean",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "SelfIntersect" : {
          "type" : "boolean",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcBeam" : {
      "domain" : null,
      "superclasses" : [ "IfcBuildingElement" ],
      "fields" : { }
    },
    "IfcBeamType" : {
      "domain" : null,
      "superclasses" : [ "IfcBuildingElementType" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcBezierCurve" : {
      "domain" : null,
      "superclasses" : [ "IfcBSplineCurve" ],
      "fields" : { }
    },
    "IfcBlobTexture" : {
      "domain" : null,
      "superclasses" : [ "IfcSurfaceTexture" ],
      "fields" : {
        "RasterFormat" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "RasterCode" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcBlock" : {
      "domain" : null,
      "superclasses" : [ "IfcCsgPrimitive3D" ],
      "fields" : {
        "XLength" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "XLengthAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "YLength" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "YLengthAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "ZLength" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "ZLengthAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcBoilerType" : {
      "domain" : null,
      "superclasses" : [ "IfcEnergyConversionDeviceType" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcBooleanClippingResult" : {
      "domain" : null,
      "superclasses" : [ "IfcBooleanResult" ],
      "fields" : { }
    },
    "IfcBooleanResult" : {
      "domain" : null,
      "superclasses" : [ "IfcGeometricRepresentationItem", "IfcBooleanOperand", "IfcCsgSelect" ],
      "fields" : {
        "Operator" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "FirstOperand" : {
          "type" : "IfcBooleanOperand",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "SecondOperand" : {
          "type" : "IfcBooleanOperand",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "Dim" : {
          "type" : "long",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcBoundaryCondition" : {
      "domain" : null,
      "superclasses" : [ ],
      "fields" : {
        "Name" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcBoundaryEdgeCondition" : {
      "domain" : null,
      "superclasses" : [ "IfcBoundaryCondition" ],
      "fields" : {
        "LinearStiffnessByLengthX" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "LinearStiffnessByLengthXAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "LinearStiffnessByLengthY" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "LinearStiffnessByLengthYAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "LinearStiffnessByLengthZ" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "LinearStiffnessByLengthZAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "RotationalStiffnessByLengthX" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "RotationalStiffnessByLengthXAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "RotationalStiffnessByLengthY" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "RotationalStiffnessByLengthYAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "RotationalStiffnessByLengthZ" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "RotationalStiffnessByLengthZAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcBoundaryFaceCondition" : {
      "domain" : null,
      "superclasses" : [ "IfcBoundaryCondition" ],
      "fields" : {
        "LinearStiffnessByAreaX" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "LinearStiffnessByAreaXAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "LinearStiffnessByAreaY" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "LinearStiffnessByAreaYAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "LinearStiffnessByAreaZ" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "LinearStiffnessByAreaZAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcBoundaryNodeCondition" : {
      "domain" : null,
      "superclasses" : [ "IfcBoundaryCondition" ],
      "fields" : {
        "LinearStiffnessX" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "LinearStiffnessXAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "LinearStiffnessY" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "LinearStiffnessYAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "LinearStiffnessZ" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "LinearStiffnessZAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "RotationalStiffnessX" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "RotationalStiffnessXAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "RotationalStiffnessY" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "RotationalStiffnessYAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "RotationalStiffnessZ" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "RotationalStiffnessZAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcBoundaryNodeConditionWarping" : {
      "domain" : null,
      "superclasses" : [ "IfcBoundaryNodeCondition" ],
      "fields" : {
        "WarpingStiffness" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "WarpingStiffnessAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcBoundedCurve" : {
      "domain" : null,
      "superclasses" : [ "IfcCurve", "IfcCurveOrEdgeCurve" ],
      "fields" : { }
    },
    "IfcBoundedSurface" : {
      "domain" : null,
      "superclasses" : [ "IfcSurface" ],
      "fields" : { }
    },
    "IfcBoundingBox" : {
      "domain" : null,
      "superclasses" : [ "IfcGeometricRepresentationItem" ],
      "fields" : {
        "Corner" : {
          "type" : "IfcCartesianPoint",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "XDim" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "XDimAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "YDim" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "YDimAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "ZDim" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "ZDimAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "Dim" : {
          "type" : "long",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcBoxedHalfSpace" : {
      "domain" : null,
      "superclasses" : [ "IfcHalfSpaceSolid" ],
      "fields" : {
        "Enclosure" : {
          "type" : "IfcBoundingBox",
          "reference" : true,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcBuilding" : {
      "domain" : null,
      "superclasses" : [ "IfcSpatialStructureElement" ],
      "fields" : {
        "ElevationOfRefHeight" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "ElevationOfRefHeightAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "ElevationOfTerrain" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "ElevationOfTerrainAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "BuildingAddress" : {
          "type" : "IfcPostalAddress",
          "reference" : true,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcBuildingElement" : {
      "domain" : null,
      "superclasses" : [ "IfcElement" ],
      "fields" : { }
    },
    "IfcBuildingElementComponent" : {
      "domain" : null,
      "superclasses" : [ "IfcBuildingElement" ],
      "fields" : { }
    },
    "IfcBuildingElementPart" : {
      "domain" : null,
      "superclasses" : [ "IfcBuildingElementComponent" ],
      "fields" : { }
    },
    "IfcBuildingElementProxy" : {
      "domain" : null,
      "superclasses" : [ "IfcBuildingElement" ],
      "fields" : {
        "CompositionType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcBuildingElementProxyType" : {
      "domain" : null,
      "superclasses" : [ "IfcBuildingElementType" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcBuildingElementType" : {
      "domain" : null,
      "superclasses" : [ "IfcElementType" ],
      "fields" : { }
    },
    "IfcBuildingStorey" : {
      "domain" : null,
      "superclasses" : [ "IfcSpatialStructureElement" ],
      "fields" : {
        "Elevation" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "ElevationAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcCShapeProfileDef" : {
      "domain" : null,
      "superclasses" : [ "IfcParameterizedProfileDef" ],
      "fields" : {
        "Depth" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "DepthAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "Width" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "WidthAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "WallThickness" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "WallThicknessAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "Girth" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "GirthAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "InternalFilletRadius" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "InternalFilletRadiusAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "CentreOfGravityInX" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "CentreOfGravityInXAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcCableCarrierFittingType" : {
      "domain" : null,
      "superclasses" : [ "IfcFlowFittingType" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcCableCarrierSegmentType" : {
      "domain" : null,
      "superclasses" : [ "IfcFlowSegmentType" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcCableSegmentType" : {
      "domain" : null,
      "superclasses" : [ "IfcFlowSegmentType" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcCalendarDate" : {
      "domain" : null,
      "superclasses" : [ "IfcDateTimeSelect", "IfcObjectReferenceSelect" ],
      "fields" : {
        "DayComponent" : {
          "type" : "long",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "MonthComponent" : {
          "type" : "long",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "YearComponent" : {
          "type" : "long",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcCartesianPoint" : {
      "domain" : null,
      "superclasses" : [ "IfcPoint", "IfcTrimmingSelect" ],
      "fields" : {
        "Coordinates" : {
          "type" : "double",
          "reference" : false,
          "many" : true,
          "inverse" : false
        },
        "CoordinatesAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : true,
          "inverse" : false
        },
        "Dim" : {
          "type" : "long",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcCartesianTransformationOperator" : {
      "domain" : null,
      "superclasses" : [ "IfcGeometricRepresentationItem" ],
      "fields" : {
        "Axis1" : {
          "type" : "IfcDirection",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "Axis2" : {
          "type" : "IfcDirection",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "LocalOrigin" : {
          "type" : "IfcCartesianPoint",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "Scale" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "ScaleAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "Dim" : {
          "type" : "long",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcCartesianTransformationOperator2D" : {
      "domain" : null,
      "superclasses" : [ "IfcCartesianTransformationOperator" ],
      "fields" : { }
    },
    "IfcCartesianTransformationOperator2DnonUniform" : {
      "domain" : null,
      "superclasses" : [ "IfcCartesianTransformationOperator2D" ],
      "fields" : {
        "Scale2" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "Scale2AsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcCartesianTransformationOperator3D" : {
      "domain" : null,
      "superclasses" : [ "IfcCartesianTransformationOperator" ],
      "fields" : {
        "Axis3" : {
          "type" : "IfcDirection",
          "reference" : true,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcCartesianTransformationOperator3DnonUniform" : {
      "domain" : null,
      "superclasses" : [ "IfcCartesianTransformationOperator3D" ],
      "fields" : {
        "Scale2" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "Scale2AsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "Scale3" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "Scale3AsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcCenterLineProfileDef" : {
      "domain" : null,
      "superclasses" : [ "IfcArbitraryOpenProfileDef" ],
      "fields" : {
        "Thickness" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "ThicknessAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcChamferEdgeFeature" : {
      "domain" : null,
      "superclasses" : [ "IfcEdgeFeature" ],
      "fields" : {
        "Width" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "WidthAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "Height" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "HeightAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcChillerType" : {
      "domain" : null,
      "superclasses" : [ "IfcEnergyConversionDeviceType" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcCircle" : {
      "domain" : null,
      "superclasses" : [ "IfcConic" ],
      "fields" : {
        "Radius" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "RadiusAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcCircleHollowProfileDef" : {
      "domain" : null,
      "superclasses" : [ "IfcCircleProfileDef" ],
      "fields" : {
        "WallThickness" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "WallThicknessAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcCircleProfileDef" : {
      "domain" : null,
      "superclasses" : [ "IfcParameterizedProfileDef" ],
      "fields" : {
        "Radius" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "RadiusAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcClassification" : {
      "domain" : null,
      "superclasses" : [ ],
      "fields" : {
        "Source" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "Edition" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "EditionDate" : {
          "type" : "IfcCalendarDate",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "Name" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "Contains" : {
          "type" : "IfcClassificationItem",
          "reference" : true,
          "many" : true,
          "inverse" : true
        }
      }
    },
    "IfcClassificationItem" : {
      "domain" : null,
      "superclasses" : [ ],
      "fields" : {
        "Notation" : {
          "type" : "IfcClassificationNotationFacet",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "ItemOf" : {
          "type" : "IfcClassification",
          "reference" : true,
          "many" : false,
          "inverse" : true
        },
        "Title" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "IsClassifiedItemIn" : {
          "type" : "IfcClassificationItemRelationship",
          "reference" : true,
          "many" : true,
          "inverse" : true
        },
        "IsClassifyingItemIn" : {
          "type" : "IfcClassificationItemRelationship",
          "reference" : true,
          "many" : true,
          "inverse" : true
        }
      }
    },
    "IfcClassificationItemRelationship" : {
      "domain" : null,
      "superclasses" : [ ],
      "fields" : {
        "RelatingItem" : {
          "type" : "IfcClassificationItem",
          "reference" : true,
          "many" : false,
          "inverse" : true
        },
        "RelatedItems" : {
          "type" : "IfcClassificationItem",
          "reference" : true,
          "many" : true,
          "inverse" : true
        }
      }
    },
    "IfcClassificationNotation" : {
      "domain" : null,
      "superclasses" : [ "IfcClassificationNotationSelect" ],
      "fields" : {
        "NotationFacets" : {
          "type" : "IfcClassificationNotationFacet",
          "reference" : true,
          "many" : true,
          "inverse" : false
        }
      }
    },
    "IfcClassificationNotationFacet" : {
      "domain" : null,
      "superclasses" : [ ],
      "fields" : {
        "NotationValue" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcClassificationReference" : {
      "domain" : null,
      "superclasses" : [ "IfcExternalReference", "IfcClassificationNotationSelect" ],
      "fields" : {
        "ReferencedSource" : {
          "type" : "IfcClassification",
          "reference" : true,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcClosedShell" : {
      "domain" : null,
      "superclasses" : [ "IfcConnectedFaceSet", "IfcShell" ],
      "fields" : { }
    },
    "IfcCoilType" : {
      "domain" : null,
      "superclasses" : [ "IfcEnergyConversionDeviceType" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcColourRgb" : {
      "domain" : null,
      "superclasses" : [ "IfcColourSpecification", "IfcColourOrFactor" ],
      "fields" : {
        "Red" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "RedAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "Green" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "GreenAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "Blue" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "BlueAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcColourSpecification" : {
      "domain" : null,
      "superclasses" : [ "IfcColour" ],
      "fields" : {
        "Name" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcColumn" : {
      "domain" : null,
      "superclasses" : [ "IfcBuildingElement" ],
      "fields" : { }
    },
    "IfcColumnType" : {
      "domain" : null,
      "superclasses" : [ "IfcBuildingElementType" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcComplexProperty" : {
      "domain" : null,
      "superclasses" : [ "IfcProperty" ],
      "fields" : {
        "UsageName" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "HasProperties" : {
          "type" : "IfcProperty",
          "reference" : true,
          "many" : true,
          "inverse" : true
        }
      }
    },
    "IfcCompositeCurve" : {
      "domain" : null,
      "superclasses" : [ "IfcBoundedCurve" ],
      "fields" : {
        "Segments" : {
          "type" : "IfcCompositeCurveSegment",
          "reference" : true,
          "many" : true,
          "inverse" : true
        },
        "SelfIntersect" : {
          "type" : "boolean",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcCompositeCurveSegment" : {
      "domain" : null,
      "superclasses" : [ "IfcGeometricRepresentationItem" ],
      "fields" : {
        "Transition" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "SameSense" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "ParentCurve" : {
          "type" : "IfcCurve",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "UsingCurves" : {
          "type" : "IfcCompositeCurve",
          "reference" : true,
          "many" : true,
          "inverse" : true
        },
        "Dim" : {
          "type" : "long",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcCompositeProfileDef" : {
      "domain" : null,
      "superclasses" : [ "IfcProfileDef" ],
      "fields" : {
        "Profiles" : {
          "type" : "IfcProfileDef",
          "reference" : true,
          "many" : true,
          "inverse" : false
        },
        "Label" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcCompressorType" : {
      "domain" : null,
      "superclasses" : [ "IfcFlowMovingDeviceType" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcCondenserType" : {
      "domain" : null,
      "superclasses" : [ "IfcEnergyConversionDeviceType" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcCondition" : {
      "domain" : null,
      "superclasses" : [ "IfcGroup" ],
      "fields" : { }
    },
    "IfcConditionCriterion" : {
      "domain" : null,
      "superclasses" : [ "IfcControl" ],
      "fields" : {
        "Criterion" : {
          "type" : "IfcConditionCriterionSelect",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "CriterionDateTime" : {
          "type" : "IfcDateTimeSelect",
          "reference" : true,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcConic" : {
      "domain" : null,
      "superclasses" : [ "IfcCurve" ],
      "fields" : {
        "Position" : {
          "type" : "IfcAxis2Placement",
          "reference" : true,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcConnectedFaceSet" : {
      "domain" : null,
      "superclasses" : [ "IfcTopologicalRepresentationItem" ],
      "fields" : {
        "CfsFaces" : {
          "type" : "IfcFace",
          "reference" : true,
          "many" : true,
          "inverse" : false
        }
      }
    },
    "IfcConnectionCurveGeometry" : {
      "domain" : null,
      "superclasses" : [ "IfcConnectionGeometry" ],
      "fields" : {
        "CurveOnRelatingElement" : {
          "type" : "IfcCurveOrEdgeCurve",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "CurveOnRelatedElement" : {
          "type" : "IfcCurveOrEdgeCurve",
          "reference" : true,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcConnectionGeometry" : {
      "domain" : null,
      "superclasses" : [ ],
      "fields" : { }
    },
    "IfcConnectionPointEccentricity" : {
      "domain" : null,
      "superclasses" : [ "IfcConnectionPointGeometry" ],
      "fields" : {
        "EccentricityInX" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "EccentricityInXAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "EccentricityInY" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "EccentricityInYAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "EccentricityInZ" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "EccentricityInZAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcConnectionPointGeometry" : {
      "domain" : null,
      "superclasses" : [ "IfcConnectionGeometry" ],
      "fields" : {
        "PointOnRelatingElement" : {
          "type" : "IfcPointOrVertexPoint",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "PointOnRelatedElement" : {
          "type" : "IfcPointOrVertexPoint",
          "reference" : true,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcConnectionPortGeometry" : {
      "domain" : null,
      "superclasses" : [ "IfcConnectionGeometry" ],
      "fields" : {
        "LocationAtRelatingElement" : {
          "type" : "IfcAxis2Placement",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "LocationAtRelatedElement" : {
          "type" : "IfcAxis2Placement",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "ProfileOfPort" : {
          "type" : "IfcProfileDef",
          "reference" : true,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcConnectionSurfaceGeometry" : {
      "domain" : null,
      "superclasses" : [ "IfcConnectionGeometry" ],
      "fields" : {
        "SurfaceOnRelatingElement" : {
          "type" : "IfcSurfaceOrFaceSurface",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "SurfaceOnRelatedElement" : {
          "type" : "IfcSurfaceOrFaceSurface",
          "reference" : true,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcConstraint" : {
      "domain" : null,
      "superclasses" : [ ],
      "fields" : {
        "Name" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "Description" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "ConstraintGrade" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "ConstraintSource" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "CreatingActor" : {
          "type" : "IfcActorSelect",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "CreationTime" : {
          "type" : "IfcDateTimeSelect",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "UserDefinedGrade" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "ClassifiedAs" : {
          "type" : "IfcConstraintClassificationRelationship",
          "reference" : true,
          "many" : true,
          "inverse" : true
        },
        "RelatesConstraints" : {
          "type" : "IfcConstraintRelationship",
          "reference" : true,
          "many" : true,
          "inverse" : true
        },
        "IsRelatedWith" : {
          "type" : "IfcConstraintRelationship",
          "reference" : true,
          "many" : true,
          "inverse" : true
        },
        "PropertiesForConstraint" : {
          "type" : "IfcPropertyConstraintRelationship",
          "reference" : true,
          "many" : true,
          "inverse" : true
        },
        "Aggregates" : {
          "type" : "IfcConstraintAggregationRelationship",
          "reference" : true,
          "many" : true,
          "inverse" : true
        },
        "IsAggregatedIn" : {
          "type" : "IfcConstraintAggregationRelationship",
          "reference" : true,
          "many" : true,
          "inverse" : true
        }
      }
    },
    "IfcConstraintAggregationRelationship" : {
      "domain" : null,
      "superclasses" : [ ],
      "fields" : {
        "Name" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "Description" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "RelatingConstraint" : {
          "type" : "IfcConstraint",
          "reference" : true,
          "many" : false,
          "inverse" : true
        },
        "RelatedConstraints" : {
          "type" : "IfcConstraint",
          "reference" : true,
          "many" : true,
          "inverse" : true
        },
        "LogicalAggregator" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcConstraintClassificationRelationship" : {
      "domain" : null,
      "superclasses" : [ ],
      "fields" : {
        "ClassifiedConstraint" : {
          "type" : "IfcConstraint",
          "reference" : true,
          "many" : false,
          "inverse" : true
        },
        "RelatedClassifications" : {
          "type" : "IfcClassificationNotationSelect",
          "reference" : true,
          "many" : true,
          "inverse" : false
        }
      }
    },
    "IfcConstraintRelationship" : {
      "domain" : null,
      "superclasses" : [ ],
      "fields" : {
        "Name" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "Description" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "RelatingConstraint" : {
          "type" : "IfcConstraint",
          "reference" : true,
          "many" : false,
          "inverse" : true
        },
        "RelatedConstraints" : {
          "type" : "IfcConstraint",
          "reference" : true,
          "many" : true,
          "inverse" : true
        }
      }
    },
    "IfcConstructionEquipmentResource" : {
      "domain" : null,
      "superclasses" : [ "IfcConstructionResource" ],
      "fields" : { }
    },
    "IfcConstructionMaterialResource" : {
      "domain" : null,
      "superclasses" : [ "IfcConstructionResource" ],
      "fields" : {
        "Suppliers" : {
          "type" : "IfcActorSelect",
          "reference" : true,
          "many" : true,
          "inverse" : false
        },
        "UsageRatio" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "UsageRatioAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcConstructionProductResource" : {
      "domain" : null,
      "superclasses" : [ "IfcConstructionResource" ],
      "fields" : { }
    },
    "IfcConstructionResource" : {
      "domain" : null,
      "superclasses" : [ "IfcResource" ],
      "fields" : {
        "ResourceIdentifier" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "ResourceGroup" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "ResourceConsumption" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "BaseQuantity" : {
          "type" : "IfcMeasureWithUnit",
          "reference" : true,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcContextDependentUnit" : {
      "domain" : null,
      "superclasses" : [ "IfcNamedUnit" ],
      "fields" : {
        "Name" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcControl" : {
      "domain" : null,
      "superclasses" : [ "IfcObject" ],
      "fields" : {
        "Controls" : {
          "type" : "IfcRelAssignsToControl",
          "reference" : true,
          "many" : true,
          "inverse" : true
        }
      }
    },
    "IfcControllerType" : {
      "domain" : null,
      "superclasses" : [ "IfcDistributionControlElementType" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcConversionBasedUnit" : {
      "domain" : null,
      "superclasses" : [ "IfcNamedUnit" ],
      "fields" : {
        "Name" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "ConversionFactor" : {
          "type" : "IfcMeasureWithUnit",
          "reference" : true,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcCooledBeamType" : {
      "domain" : null,
      "superclasses" : [ "IfcEnergyConversionDeviceType" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcCoolingTowerType" : {
      "domain" : null,
      "superclasses" : [ "IfcEnergyConversionDeviceType" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcCoordinatedUniversalTimeOffset" : {
      "domain" : null,
      "superclasses" : [ ],
      "fields" : {
        "HourOffset" : {
          "type" : "long",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "MinuteOffset" : {
          "type" : "long",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "Sense" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcCostItem" : {
      "domain" : null,
      "superclasses" : [ "IfcControl" ],
      "fields" : { }
    },
    "IfcCostSchedule" : {
      "domain" : null,
      "superclasses" : [ "IfcControl" ],
      "fields" : {
        "SubmittedBy" : {
          "type" : "IfcActorSelect",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "PreparedBy" : {
          "type" : "IfcActorSelect",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "SubmittedOn" : {
          "type" : "IfcDateTimeSelect",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "Status" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "TargetUsers" : {
          "type" : "IfcActorSelect",
          "reference" : true,
          "many" : true,
          "inverse" : false
        },
        "UpdateDate" : {
          "type" : "IfcDateTimeSelect",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "ID" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcCostValue" : {
      "domain" : null,
      "superclasses" : [ "IfcAppliedValue", "IfcMetricValueSelect" ],
      "fields" : {
        "CostType" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "Condition" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcCovering" : {
      "domain" : null,
      "superclasses" : [ "IfcBuildingElement" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "CoversSpaces" : {
          "type" : "IfcRelCoversSpaces",
          "reference" : true,
          "many" : true,
          "inverse" : true
        },
        "Covers" : {
          "type" : "IfcRelCoversBldgElements",
          "reference" : true,
          "many" : true,
          "inverse" : true
        }
      }
    },
    "IfcCoveringType" : {
      "domain" : null,
      "superclasses" : [ "IfcBuildingElementType" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcCraneRailAShapeProfileDef" : {
      "domain" : null,
      "superclasses" : [ "IfcParameterizedProfileDef" ],
      "fields" : {
        "OverallHeight" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "OverallHeightAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "BaseWidth2" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "BaseWidth2AsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "Radius" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "RadiusAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "HeadWidth" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "HeadWidthAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "HeadDepth2" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "HeadDepth2AsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "HeadDepth3" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "HeadDepth3AsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "WebThickness" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "WebThicknessAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "BaseWidth4" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "BaseWidth4AsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "BaseDepth1" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "BaseDepth1AsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "BaseDepth2" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "BaseDepth2AsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "BaseDepth3" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "BaseDepth3AsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "CentreOfGravityInY" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "CentreOfGravityInYAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcCraneRailFShapeProfileDef" : {
      "domain" : null,
      "superclasses" : [ "IfcParameterizedProfileDef" ],
      "fields" : {
        "OverallHeight" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "OverallHeightAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "HeadWidth" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "HeadWidthAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "Radius" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "RadiusAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "HeadDepth2" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "HeadDepth2AsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "HeadDepth3" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "HeadDepth3AsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "WebThickness" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "WebThicknessAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "BaseDepth1" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "BaseDepth1AsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "BaseDepth2" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "BaseDepth2AsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "CentreOfGravityInY" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "CentreOfGravityInYAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcCrewResource" : {
      "domain" : null,
      "superclasses" : [ "IfcConstructionResource" ],
      "fields" : { }
    },
    "IfcCsgPrimitive3D" : {
      "domain" : null,
      "superclasses" : [ "IfcGeometricRepresentationItem", "IfcBooleanOperand", "IfcCsgSelect" ],
      "fields" : {
        "Position" : {
          "type" : "IfcAxis2Placement3D",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "Dim" : {
          "type" : "long",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcCsgSolid" : {
      "domain" : null,
      "superclasses" : [ "IfcSolidModel" ],
      "fields" : {
        "TreeRootExpression" : {
          "type" : "IfcCsgSelect",
          "reference" : true,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcCurrencyRelationship" : {
      "domain" : null,
      "superclasses" : [ ],
      "fields" : {
        "RelatingMonetaryUnit" : {
          "type" : "IfcMonetaryUnit",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "RelatedMonetaryUnit" : {
          "type" : "IfcMonetaryUnit",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "ExchangeRate" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "ExchangeRateAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "RateDateTime" : {
          "type" : "IfcDateAndTime",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "RateSource" : {
          "type" : "IfcLibraryInformation",
          "reference" : true,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcCurtainWall" : {
      "domain" : null,
      "superclasses" : [ "IfcBuildingElement" ],
      "fields" : { }
    },
    "IfcCurtainWallType" : {
      "domain" : null,
      "superclasses" : [ "IfcBuildingElementType" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcCurve" : {
      "domain" : null,
      "superclasses" : [ "IfcGeometricRepresentationItem", "IfcGeometricSetSelect" ],
      "fields" : {
        "Dim" : {
          "type" : "long",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcCurveBoundedPlane" : {
      "domain" : null,
      "superclasses" : [ "IfcBoundedSurface" ],
      "fields" : {
        "BasisSurface" : {
          "type" : "IfcPlane",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "OuterBoundary" : {
          "type" : "IfcCurve",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "InnerBoundaries" : {
          "type" : "IfcCurve",
          "reference" : true,
          "many" : true,
          "inverse" : false
        },
        "Dim" : {
          "type" : "long",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcCurveStyle" : {
      "domain" : null,
      "superclasses" : [ "IfcPresentationStyle", "IfcPresentationStyleSelect" ],
      "fields" : {
        "CurveFont" : {
          "type" : "IfcCurveFontOrScaledCurveFontSelect",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "CurveWidth" : {
          "type" : "IfcSizeSelect",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "CurveColour" : {
          "type" : "IfcColour",
          "reference" : true,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcCurveStyleFont" : {
      "domain" : null,
      "superclasses" : [ "IfcCurveStyleFontSelect" ],
      "fields" : {
        "Name" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "PatternList" : {
          "type" : "IfcCurveStyleFontPattern",
          "reference" : true,
          "many" : true,
          "inverse" : false
        }
      }
    },
    "IfcCurveStyleFontAndScaling" : {
      "domain" : null,
      "superclasses" : [ "IfcCurveFontOrScaledCurveFontSelect" ],
      "fields" : {
        "Name" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "CurveFont" : {
          "type" : "IfcCurveStyleFontSelect",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "CurveFontScaling" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "CurveFontScalingAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcCurveStyleFontPattern" : {
      "domain" : null,
      "superclasses" : [ ],
      "fields" : {
        "VisibleSegmentLength" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "VisibleSegmentLengthAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "InvisibleSegmentLength" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "InvisibleSegmentLengthAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcDamperType" : {
      "domain" : null,
      "superclasses" : [ "IfcFlowControllerType" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcDateAndTime" : {
      "domain" : null,
      "superclasses" : [ "IfcDateTimeSelect", "IfcObjectReferenceSelect" ],
      "fields" : {
        "DateComponent" : {
          "type" : "IfcCalendarDate",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "TimeComponent" : {
          "type" : "IfcLocalTime",
          "reference" : true,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcDefinedSymbol" : {
      "domain" : null,
      "superclasses" : [ "IfcGeometricRepresentationItem" ],
      "fields" : {
        "Definition" : {
          "type" : "IfcDefinedSymbolSelect",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "Target" : {
          "type" : "IfcCartesianTransformationOperator2D",
          "reference" : true,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcDerivedProfileDef" : {
      "domain" : null,
      "superclasses" : [ "IfcProfileDef" ],
      "fields" : {
        "ParentProfile" : {
          "type" : "IfcProfileDef",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "Operator" : {
          "type" : "IfcCartesianTransformationOperator2D",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "Label" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcDerivedUnit" : {
      "domain" : null,
      "superclasses" : [ "IfcUnit" ],
      "fields" : {
        "Elements" : {
          "type" : "IfcDerivedUnitElement",
          "reference" : true,
          "many" : true,
          "inverse" : false
        },
        "UnitType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "UserDefinedType" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcDerivedUnitElement" : {
      "domain" : null,
      "superclasses" : [ ],
      "fields" : {
        "Unit" : {
          "type" : "IfcNamedUnit",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "Exponent" : {
          "type" : "long",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcDiameterDimension" : {
      "domain" : null,
      "superclasses" : [ "IfcDimensionCurveDirectedCallout" ],
      "fields" : { }
    },
    "IfcDimensionCalloutRelationship" : {
      "domain" : null,
      "superclasses" : [ "IfcDraughtingCalloutRelationship" ],
      "fields" : { }
    },
    "IfcDimensionCurve" : {
      "domain" : null,
      "superclasses" : [ "IfcAnnotationCurveOccurrence" ],
      "fields" : {
        "AnnotatedBySymbols" : {
          "type" : "IfcTerminatorSymbol",
          "reference" : true,
          "many" : true,
          "inverse" : true
        }
      }
    },
    "IfcDimensionCurveDirectedCallout" : {
      "domain" : null,
      "superclasses" : [ "IfcDraughtingCallout" ],
      "fields" : { }
    },
    "IfcDimensionCurveTerminator" : {
      "domain" : null,
      "superclasses" : [ "IfcTerminatorSymbol" ],
      "fields" : {
        "Role" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcDimensionPair" : {
      "domain" : null,
      "superclasses" : [ "IfcDraughtingCalloutRelationship" ],
      "fields" : { }
    },
    "IfcDimensionalExponents" : {
      "domain" : null,
      "superclasses" : [ ],
      "fields" : {
        "LengthExponent" : {
          "type" : "long",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "MassExponent" : {
          "type" : "long",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "TimeExponent" : {
          "type" : "long",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "ElectricCurrentExponent" : {
          "type" : "long",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "ThermodynamicTemperatureExponent" : {
          "type" : "long",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "AmountOfSubstanceExponent" : {
          "type" : "long",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "LuminousIntensityExponent" : {
          "type" : "long",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcDirection" : {
      "domain" : null,
      "superclasses" : [ "IfcGeometricRepresentationItem", "IfcOrientationSelect", "IfcVectorOrDirection" ],
      "fields" : {
        "DirectionRatios" : {
          "type" : "double",
          "reference" : false,
          "many" : true,
          "inverse" : false
        },
        "DirectionRatiosAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : true,
          "inverse" : false
        },
        "Dim" : {
          "type" : "long",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcDiscreteAccessory" : {
      "domain" : null,
      "superclasses" : [ "IfcElementComponent" ],
      "fields" : { }
    },
    "IfcDiscreteAccessoryType" : {
      "domain" : null,
      "superclasses" : [ "IfcElementComponentType" ],
      "fields" : { }
    },
    "IfcDistributionChamberElement" : {
      "domain" : null,
      "superclasses" : [ "IfcDistributionFlowElement" ],
      "fields" : { }
    },
    "IfcDistributionChamberElementType" : {
      "domain" : null,
      "superclasses" : [ "IfcDistributionFlowElementType" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcDistributionControlElement" : {
      "domain" : null,
      "superclasses" : [ "IfcDistributionElement" ],
      "fields" : {
        "ControlElementId" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "AssignedToFlowElement" : {
          "type" : "IfcRelFlowControlElements",
          "reference" : true,
          "many" : true,
          "inverse" : true
        }
      }
    },
    "IfcDistributionControlElementType" : {
      "domain" : null,
      "superclasses" : [ "IfcDistributionElementType" ],
      "fields" : { }
    },
    "IfcDistributionElement" : {
      "domain" : null,
      "superclasses" : [ "IfcElement" ],
      "fields" : { }
    },
    "IfcDistributionElementType" : {
      "domain" : null,
      "superclasses" : [ "IfcElementType" ],
      "fields" : { }
    },
    "IfcDistributionFlowElement" : {
      "domain" : null,
      "superclasses" : [ "IfcDistributionElement" ],
      "fields" : {
        "HasControlElements" : {
          "type" : "IfcRelFlowControlElements",
          "reference" : true,
          "many" : true,
          "inverse" : true
        }
      }
    },
    "IfcDistributionFlowElementType" : {
      "domain" : null,
      "superclasses" : [ "IfcDistributionElementType" ],
      "fields" : { }
    },
    "IfcDistributionPort" : {
      "domain" : null,
      "superclasses" : [ "IfcPort" ],
      "fields" : {
        "FlowDirection" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcDocumentElectronicFormat" : {
      "domain" : null,
      "superclasses" : [ ],
      "fields" : {
        "FileExtension" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "MimeContentType" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "MimeSubtype" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcDocumentInformation" : {
      "domain" : null,
      "superclasses" : [ "IfcDocumentSelect" ],
      "fields" : {
        "DocumentId" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "Name" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "Description" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "DocumentReferences" : {
          "type" : "IfcDocumentReference",
          "reference" : true,
          "many" : true,
          "inverse" : true
        },
        "Purpose" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "IntendedUse" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "Scope" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "Revision" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "DocumentOwner" : {
          "type" : "IfcActorSelect",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "Editors" : {
          "type" : "IfcActorSelect",
          "reference" : true,
          "many" : true,
          "inverse" : false
        },
        "CreationTime" : {
          "type" : "IfcDateAndTime",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "LastRevisionTime" : {
          "type" : "IfcDateAndTime",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "ElectronicFormat" : {
          "type" : "IfcDocumentElectronicFormat",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "ValidFrom" : {
          "type" : "IfcCalendarDate",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "ValidUntil" : {
          "type" : "IfcCalendarDate",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "Confidentiality" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "Status" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "IsPointedTo" : {
          "type" : "IfcDocumentInformationRelationship",
          "reference" : true,
          "many" : true,
          "inverse" : true
        },
        "IsPointer" : {
          "type" : "IfcDocumentInformationRelationship",
          "reference" : true,
          "many" : true,
          "inverse" : true
        }
      }
    },
    "IfcDocumentInformationRelationship" : {
      "domain" : null,
      "superclasses" : [ ],
      "fields" : {
        "RelatingDocument" : {
          "type" : "IfcDocumentInformation",
          "reference" : true,
          "many" : false,
          "inverse" : true
        },
        "RelatedDocuments" : {
          "type" : "IfcDocumentInformation",
          "reference" : true,
          "many" : true,
          "inverse" : true
        },
        "RelationshipType" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcDocumentReference" : {
      "domain" : null,
      "superclasses" : [ "IfcExternalReference", "IfcDocumentSelect" ],
      "fields" : {
        "ReferenceToDocument" : {
          "type" : "IfcDocumentInformation",
          "reference" : true,
          "many" : true,
          "inverse" : true
        }
      }
    },
    "IfcDoor" : {
      "domain" : null,
      "superclasses" : [ "IfcBuildingElement" ],
      "fields" : {
        "OverallHeight" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "OverallHeightAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "OverallWidth" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "OverallWidthAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcDoorLiningProperties" : {
      "domain" : null,
      "superclasses" : [ "IfcPropertySetDefinition" ],
      "fields" : {
        "LiningDepth" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "LiningDepthAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "LiningThickness" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "LiningThicknessAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "ThresholdDepth" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "ThresholdDepthAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "ThresholdThickness" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "ThresholdThicknessAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "TransomThickness" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "TransomThicknessAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "TransomOffset" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "TransomOffsetAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "LiningOffset" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "LiningOffsetAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "ThresholdOffset" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "ThresholdOffsetAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "CasingThickness" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "CasingThicknessAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "CasingDepth" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "CasingDepthAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "ShapeAspectStyle" : {
          "type" : "IfcShapeAspect",
          "reference" : true,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcDoorPanelProperties" : {
      "domain" : null,
      "superclasses" : [ "IfcPropertySetDefinition" ],
      "fields" : {
        "PanelDepth" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "PanelDepthAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "PanelOperation" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "PanelWidth" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "PanelWidthAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "PanelPosition" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "ShapeAspectStyle" : {
          "type" : "IfcShapeAspect",
          "reference" : true,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcDoorStyle" : {
      "domain" : null,
      "superclasses" : [ "IfcTypeProduct" ],
      "fields" : {
        "OperationType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "ConstructionType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "ParameterTakesPrecedence" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "Sizeable" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcDraughtingCallout" : {
      "domain" : null,
      "superclasses" : [ "IfcGeometricRepresentationItem" ],
      "fields" : {
        "Contents" : {
          "type" : "IfcDraughtingCalloutElement",
          "reference" : true,
          "many" : true,
          "inverse" : false
        },
        "IsRelatedFromCallout" : {
          "type" : "IfcDraughtingCalloutRelationship",
          "reference" : true,
          "many" : true,
          "inverse" : true
        },
        "IsRelatedToCallout" : {
          "type" : "IfcDraughtingCalloutRelationship",
          "reference" : true,
          "many" : true,
          "inverse" : true
        }
      }
    },
    "IfcDraughtingCalloutRelationship" : {
      "domain" : null,
      "superclasses" : [ ],
      "fields" : {
        "Name" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "Description" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "RelatingDraughtingCallout" : {
          "type" : "IfcDraughtingCallout",
          "reference" : true,
          "many" : false,
          "inverse" : true
        },
        "RelatedDraughtingCallout" : {
          "type" : "IfcDraughtingCallout",
          "reference" : true,
          "many" : false,
          "inverse" : true
        }
      }
    },
    "IfcDraughtingPreDefinedColour" : {
      "domain" : null,
      "superclasses" : [ "IfcPreDefinedColour" ],
      "fields" : { }
    },
    "IfcDraughtingPreDefinedCurveFont" : {
      "domain" : null,
      "superclasses" : [ "IfcPreDefinedCurveFont" ],
      "fields" : { }
    },
    "IfcDraughtingPreDefinedTextFont" : {
      "domain" : null,
      "superclasses" : [ "IfcPreDefinedTextFont" ],
      "fields" : { }
    },
    "IfcDuctFittingType" : {
      "domain" : null,
      "superclasses" : [ "IfcFlowFittingType" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcDuctSegmentType" : {
      "domain" : null,
      "superclasses" : [ "IfcFlowSegmentType" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcDuctSilencerType" : {
      "domain" : null,
      "superclasses" : [ "IfcFlowTreatmentDeviceType" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcEdge" : {
      "domain" : null,
      "superclasses" : [ "IfcTopologicalRepresentationItem" ],
      "fields" : {
        "EdgeStart" : {
          "type" : "IfcVertex",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "EdgeEnd" : {
          "type" : "IfcVertex",
          "reference" : true,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcEdgeCurve" : {
      "domain" : null,
      "superclasses" : [ "IfcEdge", "IfcCurveOrEdgeCurve" ],
      "fields" : {
        "EdgeGeometry" : {
          "type" : "IfcCurve",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "SameSense" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcEdgeFeature" : {
      "domain" : null,
      "superclasses" : [ "IfcFeatureElementSubtraction" ],
      "fields" : {
        "FeatureLength" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "FeatureLengthAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcEdgeLoop" : {
      "domain" : null,
      "superclasses" : [ "IfcLoop" ],
      "fields" : {
        "EdgeList" : {
          "type" : "IfcOrientedEdge",
          "reference" : true,
          "many" : true,
          "inverse" : false
        }
      }
    },
    "IfcElectricApplianceType" : {
      "domain" : null,
      "superclasses" : [ "IfcFlowTerminalType" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcElectricDistributionPoint" : {
      "domain" : null,
      "superclasses" : [ "IfcFlowController" ],
      "fields" : {
        "DistributionPointFunction" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "UserDefinedFunction" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcElectricFlowStorageDeviceType" : {
      "domain" : null,
      "superclasses" : [ "IfcFlowStorageDeviceType" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcElectricGeneratorType" : {
      "domain" : null,
      "superclasses" : [ "IfcEnergyConversionDeviceType" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcElectricHeaterType" : {
      "domain" : null,
      "superclasses" : [ "IfcFlowTerminalType" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcElectricMotorType" : {
      "domain" : null,
      "superclasses" : [ "IfcEnergyConversionDeviceType" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcElectricTimeControlType" : {
      "domain" : null,
      "superclasses" : [ "IfcFlowControllerType" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcElectricalBaseProperties" : {
      "domain" : null,
      "superclasses" : [ "IfcEnergyProperties" ],
      "fields" : {
        "ElectricCurrentType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "InputVoltage" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "InputVoltageAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "InputFrequency" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "InputFrequencyAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "FullLoadCurrent" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "FullLoadCurrentAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "MinimumCircuitCurrent" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "MinimumCircuitCurrentAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "MaximumPowerInput" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "MaximumPowerInputAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "RatedPowerInput" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "RatedPowerInputAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "InputPhase" : {
          "type" : "long",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcElectricalCircuit" : {
      "domain" : null,
      "superclasses" : [ "IfcSystem" ],
      "fields" : { }
    },
    "IfcElectricalElement" : {
      "domain" : null,
      "superclasses" : [ "IfcElement" ],
      "fields" : { }
    },
    "IfcElement" : {
      "domain" : null,
      "superclasses" : [ "IfcProduct", "IfcStructuralActivityAssignmentSelect" ],
      "fields" : {
        "Tag" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "HasStructuralMember" : {
          "type" : "IfcRelConnectsStructuralElement",
          "reference" : true,
          "many" : true,
          "inverse" : true
        },
        "FillsVoids" : {
          "type" : "IfcRelFillsElement",
          "reference" : true,
          "many" : true,
          "inverse" : true
        },
        "ConnectedTo" : {
          "type" : "IfcRelConnectsElements",
          "reference" : true,
          "many" : true,
          "inverse" : true
        },
        "HasCoverings" : {
          "type" : "IfcRelCoversBldgElements",
          "reference" : true,
          "many" : true,
          "inverse" : true
        },
        "HasProjections" : {
          "type" : "IfcRelProjectsElement",
          "reference" : true,
          "many" : true,
          "inverse" : true
        },
        "ReferencedInStructures" : {
          "type" : "IfcRelReferencedInSpatialStructure",
          "reference" : true,
          "many" : true,
          "inverse" : true
        },
        "HasPorts" : {
          "type" : "IfcRelConnectsPortToElement",
          "reference" : true,
          "many" : true,
          "inverse" : true
        },
        "HasOpenings" : {
          "type" : "IfcRelVoidsElement",
          "reference" : true,
          "many" : true,
          "inverse" : true
        },
        "IsConnectionRealization" : {
          "type" : "IfcRelConnectsWithRealizingElements",
          "reference" : true,
          "many" : true,
          "inverse" : true
        },
        "ProvidesBoundaries" : {
          "type" : "IfcRelSpaceBoundary",
          "reference" : true,
          "many" : true,
          "inverse" : true
        },
        "ConnectedFrom" : {
          "type" : "IfcRelConnectsElements",
          "reference" : true,
          "many" : true,
          "inverse" : true
        },
        "ContainedInStructure" : {
          "type" : "IfcRelContainedInSpatialStructure",
          "reference" : true,
          "many" : true,
          "inverse" : true
        }
      }
    },
    "IfcElementAssembly" : {
      "domain" : null,
      "superclasses" : [ "IfcElement" ],
      "fields" : {
        "AssemblyPlace" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcElementComponent" : {
      "domain" : null,
      "superclasses" : [ "IfcElement" ],
      "fields" : { }
    },
    "IfcElementComponentType" : {
      "domain" : null,
      "superclasses" : [ "IfcElementType" ],
      "fields" : { }
    },
    "IfcElementQuantity" : {
      "domain" : null,
      "superclasses" : [ "IfcPropertySetDefinition" ],
      "fields" : {
        "MethodOfMeasurement" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "Quantities" : {
          "type" : "IfcPhysicalQuantity",
          "reference" : true,
          "many" : true,
          "inverse" : false
        }
      }
    },
    "IfcElementType" : {
      "domain" : null,
      "superclasses" : [ "IfcTypeProduct" ],
      "fields" : {
        "ElementType" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcElementarySurface" : {
      "domain" : null,
      "superclasses" : [ "IfcSurface" ],
      "fields" : {
        "Position" : {
          "type" : "IfcAxis2Placement3D",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "Dim" : {
          "type" : "long",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcEllipse" : {
      "domain" : null,
      "superclasses" : [ "IfcConic" ],
      "fields" : {
        "SemiAxis1" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "SemiAxis1AsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "SemiAxis2" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "SemiAxis2AsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcEllipseProfileDef" : {
      "domain" : null,
      "superclasses" : [ "IfcParameterizedProfileDef" ],
      "fields" : {
        "SemiAxis1" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "SemiAxis1AsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "SemiAxis2" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "SemiAxis2AsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcEnergyConversionDevice" : {
      "domain" : null,
      "superclasses" : [ "IfcDistributionFlowElement" ],
      "fields" : { }
    },
    "IfcEnergyConversionDeviceType" : {
      "domain" : null,
      "superclasses" : [ "IfcDistributionFlowElementType" ],
      "fields" : { }
    },
    "IfcEnergyProperties" : {
      "domain" : null,
      "superclasses" : [ "IfcPropertySetDefinition" ],
      "fields" : {
        "EnergySequence" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "UserDefinedEnergySequence" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcEnvironmentalImpactValue" : {
      "domain" : null,
      "superclasses" : [ "IfcAppliedValue" ],
      "fields" : {
        "ImpactType" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "Category" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "UserDefinedCategory" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcEquipmentElement" : {
      "domain" : null,
      "superclasses" : [ "IfcElement" ],
      "fields" : { }
    },
    "IfcEquipmentStandard" : {
      "domain" : null,
      "superclasses" : [ "IfcControl" ],
      "fields" : { }
    },
    "IfcEvaporativeCoolerType" : {
      "domain" : null,
      "superclasses" : [ "IfcEnergyConversionDeviceType" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcEvaporatorType" : {
      "domain" : null,
      "superclasses" : [ "IfcEnergyConversionDeviceType" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcExtendedMaterialProperties" : {
      "domain" : null,
      "superclasses" : [ "IfcMaterialProperties" ],
      "fields" : {
        "ExtendedProperties" : {
          "type" : "IfcProperty",
          "reference" : true,
          "many" : true,
          "inverse" : false
        },
        "Description" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "Name" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcExternalReference" : {
      "domain" : null,
      "superclasses" : [ "IfcLightDistributionDataSourceSelect", "IfcObjectReferenceSelect" ],
      "fields" : {
        "Location" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "ItemReference" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "Name" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcExternallyDefinedHatchStyle" : {
      "domain" : null,
      "superclasses" : [ "IfcExternalReference", "IfcFillStyleSelect" ],
      "fields" : { }
    },
    "IfcExternallyDefinedSurfaceStyle" : {
      "domain" : null,
      "superclasses" : [ "IfcExternalReference", "IfcSurfaceStyleElementSelect" ],
      "fields" : { }
    },
    "IfcExternallyDefinedSymbol" : {
      "domain" : null,
      "superclasses" : [ "IfcExternalReference", "IfcDefinedSymbolSelect" ],
      "fields" : { }
    },
    "IfcExternallyDefinedTextFont" : {
      "domain" : null,
      "superclasses" : [ "IfcExternalReference", "IfcTextFontSelect" ],
      "fields" : { }
    },
    "IfcExtrudedAreaSolid" : {
      "domain" : null,
      "superclasses" : [ "IfcSweptAreaSolid" ],
      "fields" : {
        "ExtrudedDirection" : {
          "type" : "IfcDirection",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "Depth" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "DepthAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcFace" : {
      "domain" : null,
      "superclasses" : [ "IfcTopologicalRepresentationItem" ],
      "fields" : {
        "Bounds" : {
          "type" : "IfcFaceBound",
          "reference" : true,
          "many" : true,
          "inverse" : false
        }
      }
    },
    "IfcFaceBasedSurfaceModel" : {
      "domain" : null,
      "superclasses" : [ "IfcGeometricRepresentationItem", "IfcSurfaceOrFaceSurface" ],
      "fields" : {
        "FbsmFaces" : {
          "type" : "IfcConnectedFaceSet",
          "reference" : true,
          "many" : true,
          "inverse" : false
        },
        "Dim" : {
          "type" : "long",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcFaceBound" : {
      "domain" : null,
      "superclasses" : [ "IfcTopologicalRepresentationItem" ],
      "fields" : {
        "Bound" : {
          "type" : "IfcLoop",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "Orientation" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcFaceOuterBound" : {
      "domain" : null,
      "superclasses" : [ "IfcFaceBound" ],
      "fields" : { }
    },
    "IfcFaceSurface" : {
      "domain" : null,
      "superclasses" : [ "IfcFace", "IfcSurfaceOrFaceSurface" ],
      "fields" : {
        "FaceSurface" : {
          "type" : "IfcSurface",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "SameSense" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcFacetedBrep" : {
      "domain" : null,
      "superclasses" : [ "IfcManifoldSolidBrep" ],
      "fields" : { }
    },
    "IfcFacetedBrepWithVoids" : {
      "domain" : null,
      "superclasses" : [ "IfcManifoldSolidBrep" ],
      "fields" : {
        "Voids" : {
          "type" : "IfcClosedShell",
          "reference" : true,
          "many" : true,
          "inverse" : false
        }
      }
    },
    "IfcFailureConnectionCondition" : {
      "domain" : null,
      "superclasses" : [ "IfcStructuralConnectionCondition" ],
      "fields" : {
        "TensionFailureX" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "TensionFailureXAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "TensionFailureY" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "TensionFailureYAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "TensionFailureZ" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "TensionFailureZAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "CompressionFailureX" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "CompressionFailureXAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "CompressionFailureY" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "CompressionFailureYAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "CompressionFailureZ" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "CompressionFailureZAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcFanType" : {
      "domain" : null,
      "superclasses" : [ "IfcFlowMovingDeviceType" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcFastener" : {
      "domain" : null,
      "superclasses" : [ "IfcElementComponent" ],
      "fields" : { }
    },
    "IfcFastenerType" : {
      "domain" : null,
      "superclasses" : [ "IfcElementComponentType" ],
      "fields" : { }
    },
    "IfcFeatureElement" : {
      "domain" : null,
      "superclasses" : [ "IfcElement" ],
      "fields" : { }
    },
    "IfcFeatureElementAddition" : {
      "domain" : null,
      "superclasses" : [ "IfcFeatureElement" ],
      "fields" : {
        "ProjectsElements" : {
          "type" : "IfcRelProjectsElement",
          "reference" : true,
          "many" : false,
          "inverse" : true
        }
      }
    },
    "IfcFeatureElementSubtraction" : {
      "domain" : null,
      "superclasses" : [ "IfcFeatureElement" ],
      "fields" : {
        "VoidsElements" : {
          "type" : "IfcRelVoidsElement",
          "reference" : true,
          "many" : false,
          "inverse" : true
        }
      }
    },
    "IfcFillAreaStyle" : {
      "domain" : null,
      "superclasses" : [ "IfcPresentationStyle", "IfcPresentationStyleSelect" ],
      "fields" : {
        "FillStyles" : {
          "type" : "IfcFillStyleSelect",
          "reference" : true,
          "many" : true,
          "inverse" : false
        }
      }
    },
    "IfcFillAreaStyleHatching" : {
      "domain" : null,
      "superclasses" : [ "IfcGeometricRepresentationItem", "IfcFillStyleSelect" ],
      "fields" : {
        "HatchLineAppearance" : {
          "type" : "IfcCurveStyle",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "StartOfNextHatchLine" : {
          "type" : "IfcHatchLineDistanceSelect",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "PointOfReferenceHatchLine" : {
          "type" : "IfcCartesianPoint",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "PatternStart" : {
          "type" : "IfcCartesianPoint",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "HatchLineAngle" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "HatchLineAngleAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcFillAreaStyleTileSymbolWithStyle" : {
      "domain" : null,
      "superclasses" : [ "IfcGeometricRepresentationItem", "IfcFillAreaStyleTileShapeSelect" ],
      "fields" : {
        "Symbol" : {
          "type" : "IfcAnnotationSymbolOccurrence",
          "reference" : true,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcFillAreaStyleTiles" : {
      "domain" : null,
      "superclasses" : [ "IfcGeometricRepresentationItem", "IfcFillStyleSelect" ],
      "fields" : {
        "TilingPattern" : {
          "type" : "IfcOneDirectionRepeatFactor",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "Tiles" : {
          "type" : "IfcFillAreaStyleTileShapeSelect",
          "reference" : true,
          "many" : true,
          "inverse" : false
        },
        "TilingScale" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "TilingScaleAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcFilterType" : {
      "domain" : null,
      "superclasses" : [ "IfcFlowTreatmentDeviceType" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcFireSuppressionTerminalType" : {
      "domain" : null,
      "superclasses" : [ "IfcFlowTerminalType" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcFlowController" : {
      "domain" : null,
      "superclasses" : [ "IfcDistributionFlowElement" ],
      "fields" : { }
    },
    "IfcFlowControllerType" : {
      "domain" : null,
      "superclasses" : [ "IfcDistributionFlowElementType" ],
      "fields" : { }
    },
    "IfcFlowFitting" : {
      "domain" : null,
      "superclasses" : [ "IfcDistributionFlowElement" ],
      "fields" : { }
    },
    "IfcFlowFittingType" : {
      "domain" : null,
      "superclasses" : [ "IfcDistributionFlowElementType" ],
      "fields" : { }
    },
    "IfcFlowInstrumentType" : {
      "domain" : null,
      "superclasses" : [ "IfcDistributionControlElementType" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcFlowMeterType" : {
      "domain" : null,
      "superclasses" : [ "IfcFlowControllerType" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcFlowMovingDevice" : {
      "domain" : null,
      "superclasses" : [ "IfcDistributionFlowElement" ],
      "fields" : { }
    },
    "IfcFlowMovingDeviceType" : {
      "domain" : null,
      "superclasses" : [ "IfcDistributionFlowElementType" ],
      "fields" : { }
    },
    "IfcFlowSegment" : {
      "domain" : null,
      "superclasses" : [ "IfcDistributionFlowElement" ],
      "fields" : { }
    },
    "IfcFlowSegmentType" : {
      "domain" : null,
      "superclasses" : [ "IfcDistributionFlowElementType" ],
      "fields" : { }
    },
    "IfcFlowStorageDevice" : {
      "domain" : null,
      "superclasses" : [ "IfcDistributionFlowElement" ],
      "fields" : { }
    },
    "IfcFlowStorageDeviceType" : {
      "domain" : null,
      "superclasses" : [ "IfcDistributionFlowElementType" ],
      "fields" : { }
    },
    "IfcFlowTerminal" : {
      "domain" : null,
      "superclasses" : [ "IfcDistributionFlowElement" ],
      "fields" : { }
    },
    "IfcFlowTerminalType" : {
      "domain" : null,
      "superclasses" : [ "IfcDistributionFlowElementType" ],
      "fields" : { }
    },
    "IfcFlowTreatmentDevice" : {
      "domain" : null,
      "superclasses" : [ "IfcDistributionFlowElement" ],
      "fields" : { }
    },
    "IfcFlowTreatmentDeviceType" : {
      "domain" : null,
      "superclasses" : [ "IfcDistributionFlowElementType" ],
      "fields" : { }
    },
    "IfcFluidFlowProperties" : {
      "domain" : null,
      "superclasses" : [ "IfcPropertySetDefinition" ],
      "fields" : {
        "PropertySource" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "FlowConditionTimeSeries" : {
          "type" : "IfcTimeSeries",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "VelocityTimeSeries" : {
          "type" : "IfcTimeSeries",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "FlowrateTimeSeries" : {
          "type" : "IfcTimeSeries",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "Fluid" : {
          "type" : "IfcMaterial",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "PressureTimeSeries" : {
          "type" : "IfcTimeSeries",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "UserDefinedPropertySource" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "TemperatureSingleValue" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "TemperatureSingleValueAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "WetBulbTemperatureSingleValue" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "WetBulbTemperatureSingleValueAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "WetBulbTemperatureTimeSeries" : {
          "type" : "IfcTimeSeries",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "TemperatureTimeSeries" : {
          "type" : "IfcTimeSeries",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "FlowrateSingleValue" : {
          "type" : "IfcDerivedMeasureValue",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "FlowConditionSingleValue" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "FlowConditionSingleValueAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "VelocitySingleValue" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "VelocitySingleValueAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "PressureSingleValue" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "PressureSingleValueAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcFooting" : {
      "domain" : null,
      "superclasses" : [ "IfcBuildingElement" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcFuelProperties" : {
      "domain" : null,
      "superclasses" : [ "IfcMaterialProperties" ],
      "fields" : {
        "CombustionTemperature" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "CombustionTemperatureAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "CarbonContent" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "CarbonContentAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "LowerHeatingValue" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "LowerHeatingValueAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "HigherHeatingValue" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "HigherHeatingValueAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcFurnishingElement" : {
      "domain" : null,
      "superclasses" : [ "IfcElement" ],
      "fields" : { }
    },
    "IfcFurnishingElementType" : {
      "domain" : null,
      "superclasses" : [ "IfcElementType" ],
      "fields" : { }
    },
    "IfcFurnitureStandard" : {
      "domain" : null,
      "superclasses" : [ "IfcControl" ],
      "fields" : { }
    },
    "IfcFurnitureType" : {
      "domain" : null,
      "superclasses" : [ "IfcFurnishingElementType" ],
      "fields" : {
        "AssemblyPlace" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcGasTerminalType" : {
      "domain" : null,
      "superclasses" : [ "IfcFlowTerminalType" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcGeneralMaterialProperties" : {
      "domain" : null,
      "superclasses" : [ "IfcMaterialProperties" ],
      "fields" : {
        "MolecularWeight" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "MolecularWeightAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "Porosity" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "PorosityAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "MassDensity" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "MassDensityAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcGeneralProfileProperties" : {
      "domain" : null,
      "superclasses" : [ "IfcProfileProperties" ],
      "fields" : {
        "PhysicalWeight" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "PhysicalWeightAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "Perimeter" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "PerimeterAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "MinimumPlateThickness" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "MinimumPlateThicknessAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "MaximumPlateThickness" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "MaximumPlateThicknessAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "CrossSectionArea" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "CrossSectionAreaAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcGeometricCurveSet" : {
      "domain" : null,
      "superclasses" : [ "IfcGeometricSet" ],
      "fields" : { }
    },
    "IfcGeometricRepresentationContext" : {
      "domain" : null,
      "superclasses" : [ "IfcRepresentationContext" ],
      "fields" : {
        "CoordinateSpaceDimension" : {
          "type" : "long",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "Precision" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "PrecisionAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "WorldCoordinateSystem" : {
          "type" : "IfcAxis2Placement",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "TrueNorth" : {
          "type" : "IfcDirection",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "HasSubContexts" : {
          "type" : "IfcGeometricRepresentationSubContext",
          "reference" : true,
          "many" : true,
          "inverse" : true
        }
      }
    },
    "IfcGeometricRepresentationItem" : {
      "domain" : null,
      "superclasses" : [ "IfcRepresentationItem" ],
      "fields" : { }
    },
    "IfcGeometricRepresentationSubContext" : {
      "domain" : null,
      "superclasses" : [ "IfcGeometricRepresentationContext" ],
      "fields" : {
        "ParentContext" : {
          "type" : "IfcGeometricRepresentationContext",
          "reference" : true,
          "many" : false,
          "inverse" : true
        },
        "TargetScale" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "TargetScaleAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "TargetView" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "UserDefinedTargetView" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcGeometricSet" : {
      "domain" : null,
      "superclasses" : [ "IfcGeometricRepresentationItem" ],
      "fields" : {
        "Elements" : {
          "type" : "IfcGeometricSetSelect",
          "reference" : true,
          "many" : true,
          "inverse" : false
        },
        "Dim" : {
          "type" : "long",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcGrid" : {
      "domain" : null,
      "superclasses" : [ "IfcProduct" ],
      "fields" : {
        "UAxes" : {
          "type" : "IfcGridAxis",
          "reference" : true,
          "many" : true,
          "inverse" : true
        },
        "VAxes" : {
          "type" : "IfcGridAxis",
          "reference" : true,
          "many" : true,
          "inverse" : true
        },
        "WAxes" : {
          "type" : "IfcGridAxis",
          "reference" : true,
          "many" : true,
          "inverse" : true
        },
        "ContainedInStructure" : {
          "type" : "IfcRelContainedInSpatialStructure",
          "reference" : true,
          "many" : true,
          "inverse" : true
        }
      }
    },
    "IfcGridAxis" : {
      "domain" : null,
      "superclasses" : [ ],
      "fields" : {
        "AxisTag" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "AxisCurve" : {
          "type" : "IfcCurve",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "SameSense" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "PartOfW" : {
          "type" : "IfcGrid",
          "reference" : true,
          "many" : true,
          "inverse" : true
        },
        "PartOfV" : {
          "type" : "IfcGrid",
          "reference" : true,
          "many" : true,
          "inverse" : true
        },
        "PartOfU" : {
          "type" : "IfcGrid",
          "reference" : true,
          "many" : true,
          "inverse" : true
        },
        "HasIntersections" : {
          "type" : "IfcVirtualGridIntersection",
          "reference" : true,
          "many" : true,
          "inverse" : true
        }
      }
    },
    "IfcGridPlacement" : {
      "domain" : null,
      "superclasses" : [ "IfcObjectPlacement" ],
      "fields" : {
        "PlacementLocation" : {
          "type" : "IfcVirtualGridIntersection",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "PlacementRefDirection" : {
          "type" : "IfcVirtualGridIntersection",
          "reference" : true,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcGroup" : {
      "domain" : null,
      "superclasses" : [ "IfcObject" ],
      "fields" : {
        "IsGroupedBy" : {
          "type" : "IfcRelAssignsToGroup",
          "reference" : true,
          "many" : false,
          "inverse" : true
        }
      }
    },
    "IfcHalfSpaceSolid" : {
      "domain" : null,
      "superclasses" : [ "IfcGeometricRepresentationItem", "IfcBooleanOperand" ],
      "fields" : {
        "BaseSurface" : {
          "type" : "IfcSurface",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "AgreementFlag" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "Dim" : {
          "type" : "long",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcHeatExchangerType" : {
      "domain" : null,
      "superclasses" : [ "IfcEnergyConversionDeviceType" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcHumidifierType" : {
      "domain" : null,
      "superclasses" : [ "IfcEnergyConversionDeviceType" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcHygroscopicMaterialProperties" : {
      "domain" : null,
      "superclasses" : [ "IfcMaterialProperties" ],
      "fields" : {
        "UpperVaporResistanceFactor" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "UpperVaporResistanceFactorAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "LowerVaporResistanceFactor" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "LowerVaporResistanceFactorAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "IsothermalMoistureCapacity" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "IsothermalMoistureCapacityAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "VaporPermeability" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "VaporPermeabilityAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "MoistureDiffusivity" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "MoistureDiffusivityAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcIShapeProfileDef" : {
      "domain" : null,
      "superclasses" : [ "IfcParameterizedProfileDef" ],
      "fields" : {
        "OverallWidth" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "OverallWidthAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "OverallDepth" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "OverallDepthAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "WebThickness" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "WebThicknessAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "FlangeThickness" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "FlangeThicknessAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "FilletRadius" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "FilletRadiusAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcImageTexture" : {
      "domain" : null,
      "superclasses" : [ "IfcSurfaceTexture" ],
      "fields" : {
        "UrlReference" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcInventory" : {
      "domain" : null,
      "superclasses" : [ "IfcGroup" ],
      "fields" : {
        "InventoryType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "Jurisdiction" : {
          "type" : "IfcActorSelect",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "ResponsiblePersons" : {
          "type" : "IfcPerson",
          "reference" : true,
          "many" : true,
          "inverse" : false
        },
        "LastUpdateDate" : {
          "type" : "IfcCalendarDate",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "CurrentValue" : {
          "type" : "IfcCostValue",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "OriginalValue" : {
          "type" : "IfcCostValue",
          "reference" : true,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcIrregularTimeSeries" : {
      "domain" : null,
      "superclasses" : [ "IfcTimeSeries" ],
      "fields" : {
        "Values" : {
          "type" : "IfcIrregularTimeSeriesValue",
          "reference" : true,
          "many" : true,
          "inverse" : false
        }
      }
    },
    "IfcIrregularTimeSeriesValue" : {
      "domain" : null,
      "superclasses" : [ ],
      "fields" : {
        "TimeStamp" : {
          "type" : "IfcDateTimeSelect",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "ListValues" : {
          "type" : "IfcValue",
          "reference" : true,
          "many" : true,
          "inverse" : false
        }
      }
    },
    "IfcJunctionBoxType" : {
      "domain" : null,
      "superclasses" : [ "IfcFlowFittingType" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcLShapeProfileDef" : {
      "domain" : null,
      "superclasses" : [ "IfcParameterizedProfileDef" ],
      "fields" : {
        "Depth" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "DepthAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "Width" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "WidthAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "Thickness" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "ThicknessAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "FilletRadius" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "FilletRadiusAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "EdgeRadius" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "EdgeRadiusAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "LegSlope" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "LegSlopeAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "CentreOfGravityInX" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "CentreOfGravityInXAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "CentreOfGravityInY" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "CentreOfGravityInYAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcLaborResource" : {
      "domain" : null,
      "superclasses" : [ "IfcConstructionResource" ],
      "fields" : {
        "SkillSet" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcLampType" : {
      "domain" : null,
      "superclasses" : [ "IfcFlowTerminalType" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcLibraryInformation" : {
      "domain" : null,
      "superclasses" : [ "IfcLibrarySelect" ],
      "fields" : {
        "Name" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "Version" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "Publisher" : {
          "type" : "IfcOrganization",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "VersionDate" : {
          "type" : "IfcCalendarDate",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "LibraryReference" : {
          "type" : "IfcLibraryReference",
          "reference" : true,
          "many" : true,
          "inverse" : true
        }
      }
    },
    "IfcLibraryReference" : {
      "domain" : null,
      "superclasses" : [ "IfcExternalReference", "IfcLibrarySelect" ],
      "fields" : {
        "ReferenceIntoLibrary" : {
          "type" : "IfcLibraryInformation",
          "reference" : true,
          "many" : true,
          "inverse" : true
        }
      }
    },
    "IfcLightDistributionData" : {
      "domain" : null,
      "superclasses" : [ ],
      "fields" : {
        "MainPlaneAngle" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "MainPlaneAngleAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "SecondaryPlaneAngle" : {
          "type" : "double",
          "reference" : false,
          "many" : true,
          "inverse" : false
        },
        "SecondaryPlaneAngleAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : true,
          "inverse" : false
        },
        "LuminousIntensity" : {
          "type" : "double",
          "reference" : false,
          "many" : true,
          "inverse" : false
        },
        "LuminousIntensityAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : true,
          "inverse" : false
        }
      }
    },
    "IfcLightFixtureType" : {
      "domain" : null,
      "superclasses" : [ "IfcFlowTerminalType" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcLightIntensityDistribution" : {
      "domain" : null,
      "superclasses" : [ "IfcLightDistributionDataSourceSelect" ],
      "fields" : {
        "LightDistributionCurve" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "DistributionData" : {
          "type" : "IfcLightDistributionData",
          "reference" : true,
          "many" : true,
          "inverse" : false
        }
      }
    },
    "IfcLightSource" : {
      "domain" : null,
      "superclasses" : [ "IfcGeometricRepresentationItem" ],
      "fields" : {
        "Name" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "LightColour" : {
          "type" : "IfcColourRgb",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "AmbientIntensity" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "AmbientIntensityAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "Intensity" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "IntensityAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcLightSourceAmbient" : {
      "domain" : null,
      "superclasses" : [ "IfcLightSource" ],
      "fields" : { }
    },
    "IfcLightSourceDirectional" : {
      "domain" : null,
      "superclasses" : [ "IfcLightSource" ],
      "fields" : {
        "Orientation" : {
          "type" : "IfcDirection",
          "reference" : true,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcLightSourceGoniometric" : {
      "domain" : null,
      "superclasses" : [ "IfcLightSource" ],
      "fields" : {
        "Position" : {
          "type" : "IfcAxis2Placement3D",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "ColourAppearance" : {
          "type" : "IfcColourRgb",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "ColourTemperature" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "ColourTemperatureAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "LuminousFlux" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "LuminousFluxAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "LightEmissionSource" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "LightDistributionDataSource" : {
          "type" : "IfcLightDistributionDataSourceSelect",
          "reference" : true,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcLightSourcePositional" : {
      "domain" : null,
      "superclasses" : [ "IfcLightSource" ],
      "fields" : {
        "Position" : {
          "type" : "IfcCartesianPoint",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "Radius" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "RadiusAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "ConstantAttenuation" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "ConstantAttenuationAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "DistanceAttenuation" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "DistanceAttenuationAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "QuadricAttenuation" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "QuadricAttenuationAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcLightSourceSpot" : {
      "domain" : null,
      "superclasses" : [ "IfcLightSourcePositional" ],
      "fields" : {
        "Orientation" : {
          "type" : "IfcDirection",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "ConcentrationExponent" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "ConcentrationExponentAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "SpreadAngle" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "SpreadAngleAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "BeamWidthAngle" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "BeamWidthAngleAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcLine" : {
      "domain" : null,
      "superclasses" : [ "IfcCurve" ],
      "fields" : {
        "Pnt" : {
          "type" : "IfcCartesianPoint",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "Dir" : {
          "type" : "IfcVector",
          "reference" : true,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcLinearDimension" : {
      "domain" : null,
      "superclasses" : [ "IfcDimensionCurveDirectedCallout" ],
      "fields" : { }
    },
    "IfcLocalPlacement" : {
      "domain" : null,
      "superclasses" : [ "IfcObjectPlacement" ],
      "fields" : {
        "PlacementRelTo" : {
          "type" : "IfcObjectPlacement",
          "reference" : true,
          "many" : false,
          "inverse" : true
        },
        "RelativePlacement" : {
          "type" : "IfcAxis2Placement",
          "reference" : true,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcLocalTime" : {
      "domain" : null,
      "superclasses" : [ "IfcDateTimeSelect", "IfcObjectReferenceSelect" ],
      "fields" : {
        "HourComponent" : {
          "type" : "long",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "MinuteComponent" : {
          "type" : "long",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "SecondComponent" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "SecondComponentAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "Zone" : {
          "type" : "IfcCoordinatedUniversalTimeOffset",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "DaylightSavingOffset" : {
          "type" : "long",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcLoop" : {
      "domain" : null,
      "superclasses" : [ "IfcTopologicalRepresentationItem" ],
      "fields" : { }
    },
    "IfcManifoldSolidBrep" : {
      "domain" : null,
      "superclasses" : [ "IfcSolidModel" ],
      "fields" : {
        "Outer" : {
          "type" : "IfcClosedShell",
          "reference" : true,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcMappedItem" : {
      "domain" : null,
      "superclasses" : [ "IfcRepresentationItem" ],
      "fields" : {
        "MappingSource" : {
          "type" : "IfcRepresentationMap",
          "reference" : true,
          "many" : false,
          "inverse" : true
        },
        "MappingTarget" : {
          "type" : "IfcCartesianTransformationOperator",
          "reference" : true,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcMaterial" : {
      "domain" : null,
      "superclasses" : [ "IfcMaterialSelect", "IfcObjectReferenceSelect" ],
      "fields" : {
        "Name" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "HasRepresentation" : {
          "type" : "IfcMaterialDefinitionRepresentation",
          "reference" : true,
          "many" : true,
          "inverse" : true
        },
        "ClassifiedAs" : {
          "type" : "IfcMaterialClassificationRelationship",
          "reference" : true,
          "many" : true,
          "inverse" : true
        }
      }
    },
    "IfcMaterialClassificationRelationship" : {
      "domain" : null,
      "superclasses" : [ ],
      "fields" : {
        "MaterialClassifications" : {
          "type" : "IfcClassificationNotationSelect",
          "reference" : true,
          "many" : true,
          "inverse" : false
        },
        "ClassifiedMaterial" : {
          "type" : "IfcMaterial",
          "reference" : true,
          "many" : false,
          "inverse" : true
        }
      }
    },
    "IfcMaterialDefinitionRepresentation" : {
      "domain" : null,
      "superclasses" : [ "IfcProductRepresentation" ],
      "fields" : {
        "RepresentedMaterial" : {
          "type" : "IfcMaterial",
          "reference" : true,
          "many" : false,
          "inverse" : true
        }
      }
    },
    "IfcMaterialLayer" : {
      "domain" : null,
      "superclasses" : [ "IfcMaterialSelect", "IfcObjectReferenceSelect" ],
      "fields" : {
        "Material" : {
          "type" : "IfcMaterial",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "LayerThickness" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "LayerThicknessAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "IsVentilated" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "ToMaterialLayerSet" : {
          "type" : "IfcMaterialLayerSet",
          "reference" : true,
          "many" : false,
          "inverse" : true
        }
      }
    },
    "IfcMaterialLayerSet" : {
      "domain" : null,
      "superclasses" : [ "IfcMaterialSelect" ],
      "fields" : {
        "MaterialLayers" : {
          "type" : "IfcMaterialLayer",
          "reference" : true,
          "many" : true,
          "inverse" : true
        },
        "LayerSetName" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "TotalThickness" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "TotalThicknessAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcMaterialLayerSetUsage" : {
      "domain" : null,
      "superclasses" : [ "IfcMaterialSelect" ],
      "fields" : {
        "ForLayerSet" : {
          "type" : "IfcMaterialLayerSet",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "LayerSetDirection" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "DirectionSense" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "OffsetFromReferenceLine" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "OffsetFromReferenceLineAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcMaterialList" : {
      "domain" : null,
      "superclasses" : [ "IfcMaterialSelect", "IfcObjectReferenceSelect" ],
      "fields" : {
        "Materials" : {
          "type" : "IfcMaterial",
          "reference" : true,
          "many" : true,
          "inverse" : false
        }
      }
    },
    "IfcMaterialProperties" : {
      "domain" : null,
      "superclasses" : [ ],
      "fields" : {
        "Material" : {
          "type" : "IfcMaterial",
          "reference" : true,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcMeasureWithUnit" : {
      "domain" : null,
      "superclasses" : [ "IfcAppliedValueSelect", "IfcConditionCriterionSelect", "IfcMetricValueSelect" ],
      "fields" : {
        "ValueComponent" : {
          "type" : "IfcValue",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "UnitComponent" : {
          "type" : "IfcUnit",
          "reference" : true,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcMechanicalConcreteMaterialProperties" : {
      "domain" : null,
      "superclasses" : [ "IfcMechanicalMaterialProperties" ],
      "fields" : {
        "CompressiveStrength" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "CompressiveStrengthAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "MaxAggregateSize" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "MaxAggregateSizeAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "AdmixturesDescription" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "Workability" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "ProtectivePoreRatio" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "ProtectivePoreRatioAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "WaterImpermeability" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcMechanicalFastener" : {
      "domain" : null,
      "superclasses" : [ "IfcFastener" ],
      "fields" : {
        "NominalDiameter" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "NominalDiameterAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "NominalLength" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "NominalLengthAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcMechanicalFastenerType" : {
      "domain" : null,
      "superclasses" : [ "IfcFastenerType" ],
      "fields" : { }
    },
    "IfcMechanicalMaterialProperties" : {
      "domain" : null,
      "superclasses" : [ "IfcMaterialProperties" ],
      "fields" : {
        "DynamicViscosity" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "DynamicViscosityAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "YoungModulus" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "YoungModulusAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "ShearModulus" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "ShearModulusAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "PoissonRatio" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "PoissonRatioAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "ThermalExpansionCoefficient" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "ThermalExpansionCoefficientAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcMechanicalSteelMaterialProperties" : {
      "domain" : null,
      "superclasses" : [ "IfcMechanicalMaterialProperties" ],
      "fields" : {
        "YieldStress" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "YieldStressAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "UltimateStress" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "UltimateStressAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "UltimateStrain" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "UltimateStrainAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "HardeningModule" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "HardeningModuleAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "ProportionalStress" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "ProportionalStressAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "PlasticStrain" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "PlasticStrainAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "Relaxations" : {
          "type" : "IfcRelaxation",
          "reference" : true,
          "many" : true,
          "inverse" : false
        }
      }
    },
    "IfcMember" : {
      "domain" : null,
      "superclasses" : [ "IfcBuildingElement" ],
      "fields" : { }
    },
    "IfcMemberType" : {
      "domain" : null,
      "superclasses" : [ "IfcBuildingElementType" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcMetric" : {
      "domain" : null,
      "superclasses" : [ "IfcConstraint" ],
      "fields" : {
        "Benchmark" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "ValueSource" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "DataValue" : {
          "type" : "IfcMetricValueSelect",
          "reference" : true,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcMonetaryUnit" : {
      "domain" : null,
      "superclasses" : [ "IfcUnit" ],
      "fields" : {
        "Currency" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcMotorConnectionType" : {
      "domain" : null,
      "superclasses" : [ "IfcEnergyConversionDeviceType" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcMove" : {
      "domain" : null,
      "superclasses" : [ "IfcTask" ],
      "fields" : {
        "MoveFrom" : {
          "type" : "IfcSpatialStructureElement",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "MoveTo" : {
          "type" : "IfcSpatialStructureElement",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "PunchList" : {
          "type" : "string",
          "reference" : false,
          "many" : true,
          "inverse" : false
        }
      }
    },
    "IfcNamedUnit" : {
      "domain" : null,
      "superclasses" : [ "IfcUnit" ],
      "fields" : {
        "Dimensions" : {
          "type" : "IfcDimensionalExponents",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "UnitType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcObject" : {
      "domain" : null,
      "superclasses" : [ "IfcObjectDefinition" ],
      "fields" : {
        "ObjectType" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "IsDefinedBy" : {
          "type" : "IfcRelDefines",
          "reference" : true,
          "many" : true,
          "inverse" : true
        }
      }
    },
    "IfcObjectDefinition" : {
      "domain" : null,
      "superclasses" : [ "IfcRoot" ],
      "fields" : {
        "HasAssignments" : {
          "type" : "IfcRelAssigns",
          "reference" : true,
          "many" : true,
          "inverse" : true
        },
        "IsDecomposedBy" : {
          "type" : "IfcRelDecomposes",
          "reference" : true,
          "many" : true,
          "inverse" : true
        },
        "Decomposes" : {
          "type" : "IfcRelDecomposes",
          "reference" : true,
          "many" : true,
          "inverse" : true
        },
        "HasAssociations" : {
          "type" : "IfcRelAssociates",
          "reference" : true,
          "many" : true,
          "inverse" : true
        }
      }
    },
    "IfcObjectPlacement" : {
      "domain" : null,
      "superclasses" : [ ],
      "fields" : {
        "PlacesObject" : {
          "type" : "IfcProduct",
          "reference" : true,
          "many" : true,
          "inverse" : true
        },
        "ReferencedByPlacements" : {
          "type" : "IfcLocalPlacement",
          "reference" : true,
          "many" : true,
          "inverse" : true
        }
      }
    },
    "IfcObjective" : {
      "domain" : null,
      "superclasses" : [ "IfcConstraint" ],
      "fields" : {
        "BenchmarkValues" : {
          "type" : "IfcMetric",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "ResultValues" : {
          "type" : "IfcMetric",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "ObjectiveQualifier" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "UserDefinedQualifier" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcOccupant" : {
      "domain" : null,
      "superclasses" : [ "IfcActor" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcOffsetCurve2D" : {
      "domain" : null,
      "superclasses" : [ "IfcCurve" ],
      "fields" : {
        "BasisCurve" : {
          "type" : "IfcCurve",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "Distance" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "DistanceAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "SelfIntersect" : {
          "type" : "boolean",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcOffsetCurve3D" : {
      "domain" : null,
      "superclasses" : [ "IfcCurve" ],
      "fields" : {
        "BasisCurve" : {
          "type" : "IfcCurve",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "Distance" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "DistanceAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "SelfIntersect" : {
          "type" : "boolean",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "RefDirection" : {
          "type" : "IfcDirection",
          "reference" : true,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcOneDirectionRepeatFactor" : {
      "domain" : null,
      "superclasses" : [ "IfcGeometricRepresentationItem", "IfcHatchLineDistanceSelect" ],
      "fields" : {
        "RepeatFactor" : {
          "type" : "IfcVector",
          "reference" : true,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcOpenShell" : {
      "domain" : null,
      "superclasses" : [ "IfcConnectedFaceSet", "IfcShell" ],
      "fields" : { }
    },
    "IfcOpeningElement" : {
      "domain" : null,
      "superclasses" : [ "IfcFeatureElementSubtraction" ],
      "fields" : {
        "HasFillings" : {
          "type" : "IfcRelFillsElement",
          "reference" : true,
          "many" : true,
          "inverse" : true
        }
      }
    },
    "IfcOpticalMaterialProperties" : {
      "domain" : null,
      "superclasses" : [ "IfcMaterialProperties" ],
      "fields" : {
        "VisibleTransmittance" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "VisibleTransmittanceAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "SolarTransmittance" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "SolarTransmittanceAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "ThermalIrTransmittance" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "ThermalIrTransmittanceAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "ThermalIrEmissivityBack" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "ThermalIrEmissivityBackAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "ThermalIrEmissivityFront" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "ThermalIrEmissivityFrontAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "VisibleReflectanceBack" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "VisibleReflectanceBackAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "VisibleReflectanceFront" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "VisibleReflectanceFrontAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "SolarReflectanceFront" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "SolarReflectanceFrontAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "SolarReflectanceBack" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "SolarReflectanceBackAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcOrderAction" : {
      "domain" : null,
      "superclasses" : [ "IfcTask" ],
      "fields" : {
        "ActionID" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcOrganization" : {
      "domain" : null,
      "superclasses" : [ "IfcActorSelect", "IfcObjectReferenceSelect" ],
      "fields" : {
        "Id" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "Name" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "Description" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "Roles" : {
          "type" : "IfcActorRole",
          "reference" : true,
          "many" : true,
          "inverse" : false
        },
        "Addresses" : {
          "type" : "IfcAddress",
          "reference" : true,
          "many" : true,
          "inverse" : true
        },
        "IsRelatedBy" : {
          "type" : "IfcOrganizationRelationship",
          "reference" : true,
          "many" : true,
          "inverse" : true
        },
        "Relates" : {
          "type" : "IfcOrganizationRelationship",
          "reference" : true,
          "many" : true,
          "inverse" : true
        },
        "Engages" : {
          "type" : "IfcPersonAndOrganization",
          "reference" : true,
          "many" : true,
          "inverse" : true
        }
      }
    },
    "IfcOrganizationRelationship" : {
      "domain" : null,
      "superclasses" : [ ],
      "fields" : {
        "Name" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "Description" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "RelatingOrganization" : {
          "type" : "IfcOrganization",
          "reference" : true,
          "many" : false,
          "inverse" : true
        },
        "RelatedOrganizations" : {
          "type" : "IfcOrganization",
          "reference" : true,
          "many" : true,
          "inverse" : true
        }
      }
    },
    "IfcOrientedEdge" : {
      "domain" : null,
      "superclasses" : [ "IfcEdge" ],
      "fields" : {
        "EdgeElement" : {
          "type" : "IfcEdge",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "Orientation" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcOutletType" : {
      "domain" : null,
      "superclasses" : [ "IfcFlowTerminalType" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcOwnerHistory" : {
      "domain" : null,
      "superclasses" : [ ],
      "fields" : {
        "OwningUser" : {
          "type" : "IfcPersonAndOrganization",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "OwningApplication" : {
          "type" : "IfcApplication",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "State" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "ChangeAction" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "LastModifiedDate" : {
          "type" : "long",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "LastModifyingUser" : {
          "type" : "IfcPersonAndOrganization",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "LastModifyingApplication" : {
          "type" : "IfcApplication",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "CreationDate" : {
          "type" : "long",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcParameterizedProfileDef" : {
      "domain" : null,
      "superclasses" : [ "IfcProfileDef" ],
      "fields" : {
        "Position" : {
          "type" : "IfcAxis2Placement2D",
          "reference" : true,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcPath" : {
      "domain" : null,
      "superclasses" : [ "IfcTopologicalRepresentationItem" ],
      "fields" : {
        "EdgeList" : {
          "type" : "IfcOrientedEdge",
          "reference" : true,
          "many" : true,
          "inverse" : false
        }
      }
    },
    "IfcPerformanceHistory" : {
      "domain" : null,
      "superclasses" : [ "IfcControl" ],
      "fields" : {
        "LifeCyclePhase" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcPermeableCoveringProperties" : {
      "domain" : null,
      "superclasses" : [ "IfcPropertySetDefinition" ],
      "fields" : {
        "OperationType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "PanelPosition" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "FrameDepth" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "FrameDepthAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "FrameThickness" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "FrameThicknessAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "ShapeAspectStyle" : {
          "type" : "IfcShapeAspect",
          "reference" : true,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcPermit" : {
      "domain" : null,
      "superclasses" : [ "IfcControl" ],
      "fields" : {
        "PermitID" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcPerson" : {
      "domain" : null,
      "superclasses" : [ "IfcActorSelect", "IfcObjectReferenceSelect" ],
      "fields" : {
        "Id" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "FamilyName" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "GivenName" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "MiddleNames" : {
          "type" : "string",
          "reference" : false,
          "many" : true,
          "inverse" : false
        },
        "PrefixTitles" : {
          "type" : "string",
          "reference" : false,
          "many" : true,
          "inverse" : false
        },
        "SuffixTitles" : {
          "type" : "string",
          "reference" : false,
          "many" : true,
          "inverse" : false
        },
        "Roles" : {
          "type" : "IfcActorRole",
          "reference" : true,
          "many" : true,
          "inverse" : false
        },
        "Addresses" : {
          "type" : "IfcAddress",
          "reference" : true,
          "many" : true,
          "inverse" : true
        },
        "EngagedIn" : {
          "type" : "IfcPersonAndOrganization",
          "reference" : true,
          "many" : true,
          "inverse" : true
        }
      }
    },
    "IfcPersonAndOrganization" : {
      "domain" : null,
      "superclasses" : [ "IfcActorSelect", "IfcObjectReferenceSelect" ],
      "fields" : {
        "ThePerson" : {
          "type" : "IfcPerson",
          "reference" : true,
          "many" : false,
          "inverse" : true
        },
        "TheOrganization" : {
          "type" : "IfcOrganization",
          "reference" : true,
          "many" : false,
          "inverse" : true
        },
        "Roles" : {
          "type" : "IfcActorRole",
          "reference" : true,
          "many" : true,
          "inverse" : false
        }
      }
    },
    "IfcPhysicalComplexQuantity" : {
      "domain" : null,
      "superclasses" : [ "IfcPhysicalQuantity" ],
      "fields" : {
        "HasQuantities" : {
          "type" : "IfcPhysicalQuantity",
          "reference" : true,
          "many" : true,
          "inverse" : true
        },
        "Discrimination" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "Quality" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "Usage" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcPhysicalQuantity" : {
      "domain" : null,
      "superclasses" : [ ],
      "fields" : {
        "Name" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "Description" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "PartOfComplex" : {
          "type" : "IfcPhysicalComplexQuantity",
          "reference" : true,
          "many" : true,
          "inverse" : true
        }
      }
    },
    "IfcPhysicalSimpleQuantity" : {
      "domain" : null,
      "superclasses" : [ "IfcPhysicalQuantity" ],
      "fields" : {
        "Unit" : {
          "type" : "IfcNamedUnit",
          "reference" : true,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcPile" : {
      "domain" : null,
      "superclasses" : [ "IfcBuildingElement" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "ConstructionType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcPipeFittingType" : {
      "domain" : null,
      "superclasses" : [ "IfcFlowFittingType" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcPipeSegmentType" : {
      "domain" : null,
      "superclasses" : [ "IfcFlowSegmentType" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcPixelTexture" : {
      "domain" : null,
      "superclasses" : [ "IfcSurfaceTexture" ],
      "fields" : {
        "Width" : {
          "type" : "long",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "Height" : {
          "type" : "long",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "ColourComponents" : {
          "type" : "long",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "Pixel" : {
          "type" : "bytearray",
          "reference" : false,
          "many" : true,
          "inverse" : false
        }
      }
    },
    "IfcPlacement" : {
      "domain" : null,
      "superclasses" : [ "IfcGeometricRepresentationItem" ],
      "fields" : {
        "Location" : {
          "type" : "IfcCartesianPoint",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "Dim" : {
          "type" : "long",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcPlanarBox" : {
      "domain" : null,
      "superclasses" : [ "IfcPlanarExtent" ],
      "fields" : {
        "Placement" : {
          "type" : "IfcAxis2Placement",
          "reference" : true,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcPlanarExtent" : {
      "domain" : null,
      "superclasses" : [ "IfcGeometricRepresentationItem" ],
      "fields" : {
        "SizeInX" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "SizeInXAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "SizeInY" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "SizeInYAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcPlane" : {
      "domain" : null,
      "superclasses" : [ "IfcElementarySurface" ],
      "fields" : { }
    },
    "IfcPlate" : {
      "domain" : null,
      "superclasses" : [ "IfcBuildingElement" ],
      "fields" : { }
    },
    "IfcPlateType" : {
      "domain" : null,
      "superclasses" : [ "IfcBuildingElementType" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcPoint" : {
      "domain" : null,
      "superclasses" : [ "IfcGeometricRepresentationItem", "IfcGeometricSetSelect", "IfcPointOrVertexPoint" ],
      "fields" : { }
    },
    "IfcPointOnCurve" : {
      "domain" : null,
      "superclasses" : [ "IfcPoint" ],
      "fields" : {
        "BasisCurve" : {
          "type" : "IfcCurve",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "PointParameter" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "PointParameterAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "Dim" : {
          "type" : "long",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcPointOnSurface" : {
      "domain" : null,
      "superclasses" : [ "IfcPoint" ],
      "fields" : {
        "BasisSurface" : {
          "type" : "IfcSurface",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "PointParameterU" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "PointParameterUAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "PointParameterV" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "PointParameterVAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "Dim" : {
          "type" : "long",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcPolyLoop" : {
      "domain" : null,
      "superclasses" : [ "IfcLoop" ],
      "fields" : {
        "Polygon" : {
          "type" : "IfcCartesianPoint",
          "reference" : true,
          "many" : true,
          "inverse" : false
        }
      }
    },
    "IfcPolygonalBoundedHalfSpace" : {
      "domain" : null,
      "superclasses" : [ "IfcHalfSpaceSolid" ],
      "fields" : {
        "Position" : {
          "type" : "IfcAxis2Placement3D",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "PolygonalBoundary" : {
          "type" : "IfcBoundedCurve",
          "reference" : true,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcPolyline" : {
      "domain" : null,
      "superclasses" : [ "IfcBoundedCurve" ],
      "fields" : {
        "Points" : {
          "type" : "IfcCartesianPoint",
          "reference" : true,
          "many" : true,
          "inverse" : false
        }
      }
    },
    "IfcPort" : {
      "domain" : null,
      "superclasses" : [ "IfcProduct" ],
      "fields" : {
        "ContainedIn" : {
          "type" : "IfcRelConnectsPortToElement",
          "reference" : true,
          "many" : false,
          "inverse" : true
        },
        "ConnectedFrom" : {
          "type" : "IfcRelConnectsPorts",
          "reference" : true,
          "many" : true,
          "inverse" : true
        },
        "ConnectedTo" : {
          "type" : "IfcRelConnectsPorts",
          "reference" : true,
          "many" : true,
          "inverse" : true
        }
      }
    },
    "IfcPostalAddress" : {
      "domain" : null,
      "superclasses" : [ "IfcAddress" ],
      "fields" : {
        "InternalLocation" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "AddressLines" : {
          "type" : "string",
          "reference" : false,
          "many" : true,
          "inverse" : false
        },
        "PostalBox" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "Town" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "Region" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "PostalCode" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "Country" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcPreDefinedColour" : {
      "domain" : null,
      "superclasses" : [ "IfcPreDefinedItem", "IfcColour" ],
      "fields" : { }
    },
    "IfcPreDefinedCurveFont" : {
      "domain" : null,
      "superclasses" : [ "IfcPreDefinedItem", "IfcCurveStyleFontSelect" ],
      "fields" : { }
    },
    "IfcPreDefinedDimensionSymbol" : {
      "domain" : null,
      "superclasses" : [ "IfcPreDefinedSymbol" ],
      "fields" : { }
    },
    "IfcPreDefinedItem" : {
      "domain" : null,
      "superclasses" : [ ],
      "fields" : {
        "Name" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcPreDefinedPointMarkerSymbol" : {
      "domain" : null,
      "superclasses" : [ "IfcPreDefinedSymbol" ],
      "fields" : { }
    },
    "IfcPreDefinedSymbol" : {
      "domain" : null,
      "superclasses" : [ "IfcPreDefinedItem", "IfcDefinedSymbolSelect" ],
      "fields" : { }
    },
    "IfcPreDefinedTerminatorSymbol" : {
      "domain" : null,
      "superclasses" : [ "IfcPreDefinedSymbol" ],
      "fields" : { }
    },
    "IfcPreDefinedTextFont" : {
      "domain" : null,
      "superclasses" : [ "IfcPreDefinedItem", "IfcTextFontSelect" ],
      "fields" : { }
    },
    "IfcPresentationLayerAssignment" : {
      "domain" : null,
      "superclasses" : [ ],
      "fields" : {
        "Name" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "Description" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "AssignedItems" : {
          "type" : "IfcLayeredItem",
          "reference" : true,
          "many" : true,
          "inverse" : true
        },
        "Identifier" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcPresentationLayerWithStyle" : {
      "domain" : null,
      "superclasses" : [ "IfcPresentationLayerAssignment" ],
      "fields" : {
        "LayerOn" : {
          "type" : "boolean",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "LayerFrozen" : {
          "type" : "boolean",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "LayerBlocked" : {
          "type" : "boolean",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "LayerStyles" : {
          "type" : "IfcPresentationStyleSelect",
          "reference" : true,
          "many" : true,
          "inverse" : false
        }
      }
    },
    "IfcPresentationStyle" : {
      "domain" : null,
      "superclasses" : [ ],
      "fields" : {
        "Name" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcPresentationStyleAssignment" : {
      "domain" : null,
      "superclasses" : [ ],
      "fields" : {
        "Styles" : {
          "type" : "IfcPresentationStyleSelect",
          "reference" : true,
          "many" : true,
          "inverse" : false
        }
      }
    },
    "IfcProcedure" : {
      "domain" : null,
      "superclasses" : [ "IfcProcess" ],
      "fields" : {
        "ProcedureID" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "ProcedureType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "UserDefinedProcedureType" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcProcess" : {
      "domain" : null,
      "superclasses" : [ "IfcObject" ],
      "fields" : {
        "OperatesOn" : {
          "type" : "IfcRelAssignsToProcess",
          "reference" : true,
          "many" : true,
          "inverse" : true
        },
        "IsSuccessorFrom" : {
          "type" : "IfcRelSequence",
          "reference" : true,
          "many" : true,
          "inverse" : true
        },
        "IsPredecessorTo" : {
          "type" : "IfcRelSequence",
          "reference" : true,
          "many" : true,
          "inverse" : true
        }
      }
    },
    "IfcProduct" : {
      "domain" : null,
      "superclasses" : [ "IfcObject" ],
      "fields" : {
        "ObjectPlacement" : {
          "type" : "IfcObjectPlacement",
          "reference" : true,
          "many" : false,
          "inverse" : true
        },
        "Representation" : {
          "type" : "IfcProductRepresentation",
          "reference" : true,
          "many" : false,
          "inverse" : true
        },
        "ReferencedBy" : {
          "type" : "IfcRelAssignsToProduct",
          "reference" : true,
          "many" : true,
          "inverse" : true
        },
        "geometry" : {
          "type" : "GeometryInfo",
          "reference" : true,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcProductDefinitionShape" : {
      "domain" : null,
      "superclasses" : [ "IfcProductRepresentation" ],
      "fields" : {
        "ShapeOfProduct" : {
          "type" : "IfcProduct",
          "reference" : true,
          "many" : true,
          "inverse" : true
        },
        "HasShapeAspects" : {
          "type" : "IfcShapeAspect",
          "reference" : true,
          "many" : true,
          "inverse" : true
        }
      }
    },
    "IfcProductRepresentation" : {
      "domain" : null,
      "superclasses" : [ ],
      "fields" : {
        "Name" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "Description" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "Representations" : {
          "type" : "IfcRepresentation",
          "reference" : true,
          "many" : true,
          "inverse" : true
        }
      }
    },
    "IfcProductsOfCombustionProperties" : {
      "domain" : null,
      "superclasses" : [ "IfcMaterialProperties" ],
      "fields" : {
        "SpecificHeatCapacity" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "SpecificHeatCapacityAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "N20Content" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "N20ContentAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "COContent" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "COContentAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "CO2Content" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "CO2ContentAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcProfileDef" : {
      "domain" : null,
      "superclasses" : [ ],
      "fields" : {
        "ProfileType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "ProfileName" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcProfileProperties" : {
      "domain" : null,
      "superclasses" : [ ],
      "fields" : {
        "ProfileName" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "ProfileDefinition" : {
          "type" : "IfcProfileDef",
          "reference" : true,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcProject" : {
      "domain" : null,
      "superclasses" : [ "IfcObject" ],
      "fields" : {
        "LongName" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "Phase" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "RepresentationContexts" : {
          "type" : "IfcRepresentationContext",
          "reference" : true,
          "many" : true,
          "inverse" : false
        },
        "UnitsInContext" : {
          "type" : "IfcUnitAssignment",
          "reference" : true,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcProjectOrder" : {
      "domain" : null,
      "superclasses" : [ "IfcControl" ],
      "fields" : {
        "ID" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "Status" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcProjectOrderRecord" : {
      "domain" : null,
      "superclasses" : [ "IfcControl" ],
      "fields" : {
        "Records" : {
          "type" : "IfcRelAssignsToProjectOrder",
          "reference" : true,
          "many" : true,
          "inverse" : false
        },
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcProjectionCurve" : {
      "domain" : null,
      "superclasses" : [ "IfcAnnotationCurveOccurrence" ],
      "fields" : { }
    },
    "IfcProjectionElement" : {
      "domain" : null,
      "superclasses" : [ "IfcFeatureElementAddition" ],
      "fields" : { }
    },
    "IfcProperty" : {
      "domain" : null,
      "superclasses" : [ ],
      "fields" : {
        "Name" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "Description" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "PropertyForDependance" : {
          "type" : "IfcPropertyDependencyRelationship",
          "reference" : true,
          "many" : true,
          "inverse" : true
        },
        "PropertyDependsOn" : {
          "type" : "IfcPropertyDependencyRelationship",
          "reference" : true,
          "many" : true,
          "inverse" : true
        },
        "PartOfComplex" : {
          "type" : "IfcComplexProperty",
          "reference" : true,
          "many" : true,
          "inverse" : true
        }
      }
    },
    "IfcPropertyBoundedValue" : {
      "domain" : null,
      "superclasses" : [ "IfcSimpleProperty" ],
      "fields" : {
        "UpperBoundValue" : {
          "type" : "IfcValue",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "LowerBoundValue" : {
          "type" : "IfcValue",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "Unit" : {
          "type" : "IfcUnit",
          "reference" : true,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcPropertyConstraintRelationship" : {
      "domain" : null,
      "superclasses" : [ ],
      "fields" : {
        "RelatingConstraint" : {
          "type" : "IfcConstraint",
          "reference" : true,
          "many" : false,
          "inverse" : true
        },
        "RelatedProperties" : {
          "type" : "IfcProperty",
          "reference" : true,
          "many" : true,
          "inverse" : false
        },
        "Name" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "Description" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcPropertyDefinition" : {
      "domain" : null,
      "superclasses" : [ "IfcRoot" ],
      "fields" : {
        "HasAssociations" : {
          "type" : "IfcRelAssociates",
          "reference" : true,
          "many" : true,
          "inverse" : true
        }
      }
    },
    "IfcPropertyDependencyRelationship" : {
      "domain" : null,
      "superclasses" : [ ],
      "fields" : {
        "DependingProperty" : {
          "type" : "IfcProperty",
          "reference" : true,
          "many" : false,
          "inverse" : true
        },
        "DependantProperty" : {
          "type" : "IfcProperty",
          "reference" : true,
          "many" : false,
          "inverse" : true
        },
        "Name" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "Description" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "Expression" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcPropertyEnumeratedValue" : {
      "domain" : null,
      "superclasses" : [ "IfcSimpleProperty" ],
      "fields" : {
        "EnumerationValues" : {
          "type" : "IfcValue",
          "reference" : true,
          "many" : true,
          "inverse" : false
        },
        "EnumerationReference" : {
          "type" : "IfcPropertyEnumeration",
          "reference" : true,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcPropertyEnumeration" : {
      "domain" : null,
      "superclasses" : [ ],
      "fields" : {
        "Name" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "EnumerationValues" : {
          "type" : "IfcValue",
          "reference" : true,
          "many" : true,
          "inverse" : false
        },
        "Unit" : {
          "type" : "IfcUnit",
          "reference" : true,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcPropertyListValue" : {
      "domain" : null,
      "superclasses" : [ "IfcSimpleProperty" ],
      "fields" : {
        "ListValues" : {
          "type" : "IfcValue",
          "reference" : true,
          "many" : true,
          "inverse" : false
        },
        "Unit" : {
          "type" : "IfcUnit",
          "reference" : true,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcPropertyReferenceValue" : {
      "domain" : null,
      "superclasses" : [ "IfcSimpleProperty" ],
      "fields" : {
        "UsageName" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "PropertyReference" : {
          "type" : "IfcObjectReferenceSelect",
          "reference" : true,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcPropertySet" : {
      "domain" : null,
      "superclasses" : [ "IfcPropertySetDefinition" ],
      "fields" : {
        "HasProperties" : {
          "type" : "IfcProperty",
          "reference" : true,
          "many" : true,
          "inverse" : false
        }
      }
    },
    "IfcPropertySetDefinition" : {
      "domain" : null,
      "superclasses" : [ "IfcPropertyDefinition" ],
      "fields" : {
        "PropertyDefinitionOf" : {
          "type" : "IfcRelDefinesByProperties",
          "reference" : true,
          "many" : true,
          "inverse" : true
        },
        "DefinesType" : {
          "type" : "IfcTypeObject",
          "reference" : true,
          "many" : true,
          "inverse" : true
        }
      }
    },
    "IfcPropertySingleValue" : {
      "domain" : null,
      "superclasses" : [ "IfcSimpleProperty" ],
      "fields" : {
        "NominalValue" : {
          "type" : "IfcValue",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "Unit" : {
          "type" : "IfcUnit",
          "reference" : true,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcPropertyTableValue" : {
      "domain" : null,
      "superclasses" : [ "IfcSimpleProperty" ],
      "fields" : {
        "DefiningValues" : {
          "type" : "IfcValue",
          "reference" : true,
          "many" : true,
          "inverse" : false
        },
        "DefinedValues" : {
          "type" : "IfcValue",
          "reference" : true,
          "many" : true,
          "inverse" : false
        },
        "Expression" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "DefiningUnit" : {
          "type" : "IfcUnit",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "DefinedUnit" : {
          "type" : "IfcUnit",
          "reference" : true,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcProtectiveDeviceType" : {
      "domain" : null,
      "superclasses" : [ "IfcFlowControllerType" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcProxy" : {
      "domain" : null,
      "superclasses" : [ "IfcProduct" ],
      "fields" : {
        "ProxyType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "Tag" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcPumpType" : {
      "domain" : null,
      "superclasses" : [ "IfcFlowMovingDeviceType" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcQuantityArea" : {
      "domain" : null,
      "superclasses" : [ "IfcPhysicalSimpleQuantity" ],
      "fields" : {
        "AreaValue" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "AreaValueAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcQuantityCount" : {
      "domain" : null,
      "superclasses" : [ "IfcPhysicalSimpleQuantity" ],
      "fields" : {
        "CountValue" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "CountValueAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcQuantityLength" : {
      "domain" : null,
      "superclasses" : [ "IfcPhysicalSimpleQuantity" ],
      "fields" : {
        "LengthValue" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "LengthValueAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcQuantityTime" : {
      "domain" : null,
      "superclasses" : [ "IfcPhysicalSimpleQuantity" ],
      "fields" : {
        "TimeValue" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "TimeValueAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcQuantityVolume" : {
      "domain" : null,
      "superclasses" : [ "IfcPhysicalSimpleQuantity" ],
      "fields" : {
        "VolumeValue" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "VolumeValueAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcQuantityWeight" : {
      "domain" : null,
      "superclasses" : [ "IfcPhysicalSimpleQuantity" ],
      "fields" : {
        "WeightValue" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "WeightValueAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcRadiusDimension" : {
      "domain" : null,
      "superclasses" : [ "IfcDimensionCurveDirectedCallout" ],
      "fields" : { }
    },
    "IfcRailing" : {
      "domain" : null,
      "superclasses" : [ "IfcBuildingElement" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcRailingType" : {
      "domain" : null,
      "superclasses" : [ "IfcBuildingElementType" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcRamp" : {
      "domain" : null,
      "superclasses" : [ "IfcBuildingElement" ],
      "fields" : {
        "ShapeType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcRampFlight" : {
      "domain" : null,
      "superclasses" : [ "IfcBuildingElement" ],
      "fields" : { }
    },
    "IfcRampFlightType" : {
      "domain" : null,
      "superclasses" : [ "IfcBuildingElementType" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcRationalBezierCurve" : {
      "domain" : null,
      "superclasses" : [ "IfcBezierCurve" ],
      "fields" : {
        "WeightsData" : {
          "type" : "double",
          "reference" : false,
          "many" : true,
          "inverse" : false
        },
        "WeightsDataAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : true,
          "inverse" : false
        }
      }
    },
    "IfcRectangleHollowProfileDef" : {
      "domain" : null,
      "superclasses" : [ "IfcRectangleProfileDef" ],
      "fields" : {
        "WallThickness" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "WallThicknessAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "InnerFilletRadius" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "InnerFilletRadiusAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "OuterFilletRadius" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "OuterFilletRadiusAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcRectangleProfileDef" : {
      "domain" : null,
      "superclasses" : [ "IfcParameterizedProfileDef" ],
      "fields" : {
        "XDim" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "XDimAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "YDim" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "YDimAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcRectangularPyramid" : {
      "domain" : null,
      "superclasses" : [ "IfcCsgPrimitive3D" ],
      "fields" : {
        "XLength" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "XLengthAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "YLength" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "YLengthAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "Height" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "HeightAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcRectangularTrimmedSurface" : {
      "domain" : null,
      "superclasses" : [ "IfcBoundedSurface" ],
      "fields" : {
        "BasisSurface" : {
          "type" : "IfcSurface",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "U1" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "U1AsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "V1" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "V1AsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "U2" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "U2AsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "V2" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "V2AsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "Usense" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "Vsense" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "Dim" : {
          "type" : "long",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcReferencesValueDocument" : {
      "domain" : null,
      "superclasses" : [ ],
      "fields" : {
        "ReferencedDocument" : {
          "type" : "IfcDocumentSelect",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "ReferencingValues" : {
          "type" : "IfcAppliedValue",
          "reference" : true,
          "many" : true,
          "inverse" : true
        },
        "Name" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "Description" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcRegularTimeSeries" : {
      "domain" : null,
      "superclasses" : [ "IfcTimeSeries" ],
      "fields" : {
        "TimeStep" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "TimeStepAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "Values" : {
          "type" : "IfcTimeSeriesValue",
          "reference" : true,
          "many" : true,
          "inverse" : false
        }
      }
    },
    "IfcReinforcementBarProperties" : {
      "domain" : null,
      "superclasses" : [ ],
      "fields" : {
        "TotalCrossSectionArea" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "TotalCrossSectionAreaAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "SteelGrade" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "BarSurface" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "EffectiveDepth" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "EffectiveDepthAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "NominalBarDiameter" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "NominalBarDiameterAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "BarCount" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "BarCountAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcReinforcementDefinitionProperties" : {
      "domain" : null,
      "superclasses" : [ "IfcPropertySetDefinition" ],
      "fields" : {
        "DefinitionType" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "ReinforcementSectionDefinitions" : {
          "type" : "IfcSectionReinforcementProperties",
          "reference" : true,
          "many" : true,
          "inverse" : false
        }
      }
    },
    "IfcReinforcingBar" : {
      "domain" : null,
      "superclasses" : [ "IfcReinforcingElement" ],
      "fields" : {
        "NominalDiameter" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "NominalDiameterAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "CrossSectionArea" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "CrossSectionAreaAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "BarLength" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "BarLengthAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "BarRole" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "BarSurface" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcReinforcingElement" : {
      "domain" : null,
      "superclasses" : [ "IfcBuildingElementComponent" ],
      "fields" : {
        "SteelGrade" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcReinforcingMesh" : {
      "domain" : null,
      "superclasses" : [ "IfcReinforcingElement" ],
      "fields" : {
        "MeshLength" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "MeshLengthAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "MeshWidth" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "MeshWidthAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "LongitudinalBarNominalDiameter" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "LongitudinalBarNominalDiameterAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "TransverseBarNominalDiameter" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "TransverseBarNominalDiameterAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "LongitudinalBarCrossSectionArea" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "LongitudinalBarCrossSectionAreaAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "TransverseBarCrossSectionArea" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "TransverseBarCrossSectionAreaAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "LongitudinalBarSpacing" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "LongitudinalBarSpacingAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "TransverseBarSpacing" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "TransverseBarSpacingAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcRelAggregates" : {
      "domain" : null,
      "superclasses" : [ "IfcRelDecomposes" ],
      "fields" : { }
    },
    "IfcRelAssigns" : {
      "domain" : null,
      "superclasses" : [ "IfcRelationship" ],
      "fields" : {
        "RelatedObjects" : {
          "type" : "IfcObjectDefinition",
          "reference" : true,
          "many" : true,
          "inverse" : true
        },
        "RelatedObjectsType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcRelAssignsTasks" : {
      "domain" : null,
      "superclasses" : [ "IfcRelAssignsToControl" ],
      "fields" : {
        "TimeForTask" : {
          "type" : "IfcScheduleTimeControl",
          "reference" : true,
          "many" : false,
          "inverse" : true
        }
      }
    },
    "IfcRelAssignsToActor" : {
      "domain" : null,
      "superclasses" : [ "IfcRelAssigns" ],
      "fields" : {
        "RelatingActor" : {
          "type" : "IfcActor",
          "reference" : true,
          "many" : false,
          "inverse" : true
        },
        "ActingRole" : {
          "type" : "IfcActorRole",
          "reference" : true,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcRelAssignsToControl" : {
      "domain" : null,
      "superclasses" : [ "IfcRelAssigns" ],
      "fields" : {
        "RelatingControl" : {
          "type" : "IfcControl",
          "reference" : true,
          "many" : false,
          "inverse" : true
        }
      }
    },
    "IfcRelAssignsToGroup" : {
      "domain" : null,
      "superclasses" : [ "IfcRelAssigns" ],
      "fields" : {
        "RelatingGroup" : {
          "type" : "IfcGroup",
          "reference" : true,
          "many" : false,
          "inverse" : true
        }
      }
    },
    "IfcRelAssignsToProcess" : {
      "domain" : null,
      "superclasses" : [ "IfcRelAssigns" ],
      "fields" : {
        "RelatingProcess" : {
          "type" : "IfcProcess",
          "reference" : true,
          "many" : false,
          "inverse" : true
        },
        "QuantityInProcess" : {
          "type" : "IfcMeasureWithUnit",
          "reference" : true,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcRelAssignsToProduct" : {
      "domain" : null,
      "superclasses" : [ "IfcRelAssigns" ],
      "fields" : {
        "RelatingProduct" : {
          "type" : "IfcProduct",
          "reference" : true,
          "many" : false,
          "inverse" : true
        }
      }
    },
    "IfcRelAssignsToProjectOrder" : {
      "domain" : null,
      "superclasses" : [ "IfcRelAssignsToControl" ],
      "fields" : { }
    },
    "IfcRelAssignsToResource" : {
      "domain" : null,
      "superclasses" : [ "IfcRelAssigns" ],
      "fields" : {
        "RelatingResource" : {
          "type" : "IfcResource",
          "reference" : true,
          "many" : false,
          "inverse" : true
        }
      }
    },
    "IfcRelAssociates" : {
      "domain" : null,
      "superclasses" : [ "IfcRelationship" ],
      "fields" : {
        "RelatedObjects" : {
          "type" : "IfcRoot",
          "reference" : true,
          "many" : true,
          "inverse" : true
        }
      }
    },
    "IfcRelAssociatesAppliedValue" : {
      "domain" : null,
      "superclasses" : [ "IfcRelAssociates" ],
      "fields" : {
        "RelatingAppliedValue" : {
          "type" : "IfcAppliedValue",
          "reference" : true,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcRelAssociatesApproval" : {
      "domain" : null,
      "superclasses" : [ "IfcRelAssociates" ],
      "fields" : {
        "RelatingApproval" : {
          "type" : "IfcApproval",
          "reference" : true,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcRelAssociatesClassification" : {
      "domain" : null,
      "superclasses" : [ "IfcRelAssociates" ],
      "fields" : {
        "RelatingClassification" : {
          "type" : "IfcClassificationNotationSelect",
          "reference" : true,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcRelAssociatesConstraint" : {
      "domain" : null,
      "superclasses" : [ "IfcRelAssociates" ],
      "fields" : {
        "Intent" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "RelatingConstraint" : {
          "type" : "IfcConstraint",
          "reference" : true,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcRelAssociatesDocument" : {
      "domain" : null,
      "superclasses" : [ "IfcRelAssociates" ],
      "fields" : {
        "RelatingDocument" : {
          "type" : "IfcDocumentSelect",
          "reference" : true,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcRelAssociatesLibrary" : {
      "domain" : null,
      "superclasses" : [ "IfcRelAssociates" ],
      "fields" : {
        "RelatingLibrary" : {
          "type" : "IfcLibrarySelect",
          "reference" : true,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcRelAssociatesMaterial" : {
      "domain" : null,
      "superclasses" : [ "IfcRelAssociates" ],
      "fields" : {
        "RelatingMaterial" : {
          "type" : "IfcMaterialSelect",
          "reference" : true,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcRelAssociatesProfileProperties" : {
      "domain" : null,
      "superclasses" : [ "IfcRelAssociates" ],
      "fields" : {
        "RelatingProfileProperties" : {
          "type" : "IfcProfileProperties",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "ProfileSectionLocation" : {
          "type" : "IfcShapeAspect",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "ProfileOrientation" : {
          "type" : "IfcOrientationSelect",
          "reference" : true,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcRelConnects" : {
      "domain" : null,
      "superclasses" : [ "IfcRelationship" ],
      "fields" : { }
    },
    "IfcRelConnectsElements" : {
      "domain" : null,
      "superclasses" : [ "IfcRelConnects" ],
      "fields" : {
        "ConnectionGeometry" : {
          "type" : "IfcConnectionGeometry",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "RelatingElement" : {
          "type" : "IfcElement",
          "reference" : true,
          "many" : false,
          "inverse" : true
        },
        "RelatedElement" : {
          "type" : "IfcElement",
          "reference" : true,
          "many" : false,
          "inverse" : true
        }
      }
    },
    "IfcRelConnectsPathElements" : {
      "domain" : null,
      "superclasses" : [ "IfcRelConnectsElements" ],
      "fields" : {
        "RelatingPriorities" : {
          "type" : "long",
          "reference" : false,
          "many" : true,
          "inverse" : false
        },
        "RelatedPriorities" : {
          "type" : "long",
          "reference" : false,
          "many" : true,
          "inverse" : false
        },
        "RelatedConnectionType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "RelatingConnectionType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcRelConnectsPortToElement" : {
      "domain" : null,
      "superclasses" : [ "IfcRelConnects" ],
      "fields" : {
        "RelatingPort" : {
          "type" : "IfcPort",
          "reference" : true,
          "many" : false,
          "inverse" : true
        },
        "RelatedElement" : {
          "type" : "IfcElement",
          "reference" : true,
          "many" : false,
          "inverse" : true
        }
      }
    },
    "IfcRelConnectsPorts" : {
      "domain" : null,
      "superclasses" : [ "IfcRelConnects" ],
      "fields" : {
        "RelatingPort" : {
          "type" : "IfcPort",
          "reference" : true,
          "many" : false,
          "inverse" : true
        },
        "RelatedPort" : {
          "type" : "IfcPort",
          "reference" : true,
          "many" : false,
          "inverse" : true
        },
        "RealizingElement" : {
          "type" : "IfcElement",
          "reference" : true,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcRelConnectsStructuralActivity" : {
      "domain" : null,
      "superclasses" : [ "IfcRelConnects" ],
      "fields" : {
        "RelatingElement" : {
          "type" : "IfcStructuralActivityAssignmentSelect",
          "reference" : true,
          "many" : false,
          "inverse" : true
        },
        "RelatedStructuralActivity" : {
          "type" : "IfcStructuralActivity",
          "reference" : true,
          "many" : false,
          "inverse" : true
        }
      }
    },
    "IfcRelConnectsStructuralElement" : {
      "domain" : null,
      "superclasses" : [ "IfcRelConnects" ],
      "fields" : {
        "RelatingElement" : {
          "type" : "IfcElement",
          "reference" : true,
          "many" : false,
          "inverse" : true
        },
        "RelatedStructuralMember" : {
          "type" : "IfcStructuralMember",
          "reference" : true,
          "many" : false,
          "inverse" : true
        }
      }
    },
    "IfcRelConnectsStructuralMember" : {
      "domain" : null,
      "superclasses" : [ "IfcRelConnects" ],
      "fields" : {
        "RelatingStructuralMember" : {
          "type" : "IfcStructuralMember",
          "reference" : true,
          "many" : false,
          "inverse" : true
        },
        "RelatedStructuralConnection" : {
          "type" : "IfcStructuralConnection",
          "reference" : true,
          "many" : false,
          "inverse" : true
        },
        "AppliedCondition" : {
          "type" : "IfcBoundaryCondition",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "AdditionalConditions" : {
          "type" : "IfcStructuralConnectionCondition",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "SupportedLength" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "SupportedLengthAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "ConditionCoordinateSystem" : {
          "type" : "IfcAxis2Placement3D",
          "reference" : true,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcRelConnectsWithEccentricity" : {
      "domain" : null,
      "superclasses" : [ "IfcRelConnectsStructuralMember" ],
      "fields" : {
        "ConnectionConstraint" : {
          "type" : "IfcConnectionGeometry",
          "reference" : true,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcRelConnectsWithRealizingElements" : {
      "domain" : null,
      "superclasses" : [ "IfcRelConnectsElements" ],
      "fields" : {
        "RealizingElements" : {
          "type" : "IfcElement",
          "reference" : true,
          "many" : true,
          "inverse" : true
        },
        "ConnectionType" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcRelContainedInSpatialStructure" : {
      "domain" : null,
      "superclasses" : [ "IfcRelConnects" ],
      "fields" : {
        "RelatedElements" : {
          "type" : "IfcProduct",
          "reference" : true,
          "many" : true,
          "inverse" : true
        },
        "RelatingStructure" : {
          "type" : "IfcSpatialStructureElement",
          "reference" : true,
          "many" : false,
          "inverse" : true
        }
      }
    },
    "IfcRelCoversBldgElements" : {
      "domain" : null,
      "superclasses" : [ "IfcRelConnects" ],
      "fields" : {
        "RelatingBuildingElement" : {
          "type" : "IfcElement",
          "reference" : true,
          "many" : false,
          "inverse" : true
        },
        "RelatedCoverings" : {
          "type" : "IfcCovering",
          "reference" : true,
          "many" : true,
          "inverse" : true
        }
      }
    },
    "IfcRelCoversSpaces" : {
      "domain" : null,
      "superclasses" : [ "IfcRelConnects" ],
      "fields" : {
        "RelatedSpace" : {
          "type" : "IfcSpace",
          "reference" : true,
          "many" : false,
          "inverse" : true
        },
        "RelatedCoverings" : {
          "type" : "IfcCovering",
          "reference" : true,
          "many" : true,
          "inverse" : true
        }
      }
    },
    "IfcRelDecomposes" : {
      "domain" : null,
      "superclasses" : [ "IfcRelationship" ],
      "fields" : {
        "RelatingObject" : {
          "type" : "IfcObjectDefinition",
          "reference" : true,
          "many" : false,
          "inverse" : true
        },
        "RelatedObjects" : {
          "type" : "IfcObjectDefinition",
          "reference" : true,
          "many" : true,
          "inverse" : true
        }
      }
    },
    "IfcRelDefines" : {
      "domain" : null,
      "superclasses" : [ "IfcRelationship" ],
      "fields" : {
        "RelatedObjects" : {
          "type" : "IfcObject",
          "reference" : true,
          "many" : true,
          "inverse" : true
        }
      }
    },
    "IfcRelDefinesByProperties" : {
      "domain" : null,
      "superclasses" : [ "IfcRelDefines" ],
      "fields" : {
        "RelatingPropertyDefinition" : {
          "type" : "IfcPropertySetDefinition",
          "reference" : true,
          "many" : false,
          "inverse" : true
        }
      }
    },
    "IfcRelDefinesByType" : {
      "domain" : null,
      "superclasses" : [ "IfcRelDefines" ],
      "fields" : {
        "RelatingType" : {
          "type" : "IfcTypeObject",
          "reference" : true,
          "many" : false,
          "inverse" : true
        }
      }
    },
    "IfcRelFillsElement" : {
      "domain" : null,
      "superclasses" : [ "IfcRelConnects" ],
      "fields" : {
        "RelatingOpeningElement" : {
          "type" : "IfcOpeningElement",
          "reference" : true,
          "many" : false,
          "inverse" : true
        },
        "RelatedBuildingElement" : {
          "type" : "IfcElement",
          "reference" : true,
          "many" : false,
          "inverse" : true
        }
      }
    },
    "IfcRelFlowControlElements" : {
      "domain" : null,
      "superclasses" : [ "IfcRelConnects" ],
      "fields" : {
        "RelatedControlElements" : {
          "type" : "IfcDistributionControlElement",
          "reference" : true,
          "many" : true,
          "inverse" : true
        },
        "RelatingFlowElement" : {
          "type" : "IfcDistributionFlowElement",
          "reference" : true,
          "many" : false,
          "inverse" : true
        }
      }
    },
    "IfcRelInteractionRequirements" : {
      "domain" : null,
      "superclasses" : [ "IfcRelConnects" ],
      "fields" : {
        "DailyInteraction" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "DailyInteractionAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "ImportanceRating" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "ImportanceRatingAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "LocationOfInteraction" : {
          "type" : "IfcSpatialStructureElement",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "RelatedSpaceProgram" : {
          "type" : "IfcSpaceProgram",
          "reference" : true,
          "many" : false,
          "inverse" : true
        },
        "RelatingSpaceProgram" : {
          "type" : "IfcSpaceProgram",
          "reference" : true,
          "many" : false,
          "inverse" : true
        }
      }
    },
    "IfcRelNests" : {
      "domain" : null,
      "superclasses" : [ "IfcRelDecomposes" ],
      "fields" : { }
    },
    "IfcRelOccupiesSpaces" : {
      "domain" : null,
      "superclasses" : [ "IfcRelAssignsToActor" ],
      "fields" : { }
    },
    "IfcRelOverridesProperties" : {
      "domain" : null,
      "superclasses" : [ "IfcRelDefinesByProperties" ],
      "fields" : {
        "OverridingProperties" : {
          "type" : "IfcProperty",
          "reference" : true,
          "many" : true,
          "inverse" : false
        }
      }
    },
    "IfcRelProjectsElement" : {
      "domain" : null,
      "superclasses" : [ "IfcRelConnects" ],
      "fields" : {
        "RelatingElement" : {
          "type" : "IfcElement",
          "reference" : true,
          "many" : false,
          "inverse" : true
        },
        "RelatedFeatureElement" : {
          "type" : "IfcFeatureElementAddition",
          "reference" : true,
          "many" : false,
          "inverse" : true
        }
      }
    },
    "IfcRelReferencedInSpatialStructure" : {
      "domain" : null,
      "superclasses" : [ "IfcRelConnects" ],
      "fields" : {
        "RelatedElements" : {
          "type" : "IfcProduct",
          "reference" : true,
          "many" : true,
          "inverse" : true
        },
        "RelatingStructure" : {
          "type" : "IfcSpatialStructureElement",
          "reference" : true,
          "many" : false,
          "inverse" : true
        }
      }
    },
    "IfcRelSchedulesCostItems" : {
      "domain" : null,
      "superclasses" : [ "IfcRelAssignsToControl" ],
      "fields" : { }
    },
    "IfcRelSequence" : {
      "domain" : null,
      "superclasses" : [ "IfcRelConnects" ],
      "fields" : {
        "RelatingProcess" : {
          "type" : "IfcProcess",
          "reference" : true,
          "many" : false,
          "inverse" : true
        },
        "RelatedProcess" : {
          "type" : "IfcProcess",
          "reference" : true,
          "many" : false,
          "inverse" : true
        },
        "TimeLag" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "TimeLagAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "SequenceType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcRelServicesBuildings" : {
      "domain" : null,
      "superclasses" : [ "IfcRelConnects" ],
      "fields" : {
        "RelatingSystem" : {
          "type" : "IfcSystem",
          "reference" : true,
          "many" : false,
          "inverse" : true
        },
        "RelatedBuildings" : {
          "type" : "IfcSpatialStructureElement",
          "reference" : true,
          "many" : true,
          "inverse" : true
        }
      }
    },
    "IfcRelSpaceBoundary" : {
      "domain" : null,
      "superclasses" : [ "IfcRelConnects" ],
      "fields" : {
        "RelatingSpace" : {
          "type" : "IfcSpace",
          "reference" : true,
          "many" : false,
          "inverse" : true
        },
        "RelatedBuildingElement" : {
          "type" : "IfcElement",
          "reference" : true,
          "many" : false,
          "inverse" : true
        },
        "ConnectionGeometry" : {
          "type" : "IfcConnectionGeometry",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "PhysicalOrVirtualBoundary" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "InternalOrExternalBoundary" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcRelVoidsElement" : {
      "domain" : null,
      "superclasses" : [ "IfcRelConnects" ],
      "fields" : {
        "RelatingBuildingElement" : {
          "type" : "IfcElement",
          "reference" : true,
          "many" : false,
          "inverse" : true
        },
        "RelatedOpeningElement" : {
          "type" : "IfcFeatureElementSubtraction",
          "reference" : true,
          "many" : false,
          "inverse" : true
        }
      }
    },
    "IfcRelationship" : {
      "domain" : null,
      "superclasses" : [ "IfcRoot" ],
      "fields" : { }
    },
    "IfcRelaxation" : {
      "domain" : null,
      "superclasses" : [ ],
      "fields" : {
        "RelaxationValue" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "RelaxationValueAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "InitialStress" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "InitialStressAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcRepresentation" : {
      "domain" : null,
      "superclasses" : [ "IfcLayeredItem" ],
      "fields" : {
        "ContextOfItems" : {
          "type" : "IfcRepresentationContext",
          "reference" : true,
          "many" : false,
          "inverse" : true
        },
        "RepresentationIdentifier" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "RepresentationType" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "Items" : {
          "type" : "IfcRepresentationItem",
          "reference" : true,
          "many" : true,
          "inverse" : false
        },
        "RepresentationMap" : {
          "type" : "IfcRepresentationMap",
          "reference" : true,
          "many" : true,
          "inverse" : true
        },
        "LayerAssignments" : {
          "type" : "IfcPresentationLayerAssignment",
          "reference" : true,
          "many" : true,
          "inverse" : true
        },
        "OfProductRepresentation" : {
          "type" : "IfcProductRepresentation",
          "reference" : true,
          "many" : true,
          "inverse" : true
        }
      }
    },
    "IfcRepresentationContext" : {
      "domain" : null,
      "superclasses" : [ ],
      "fields" : {
        "ContextIdentifier" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "ContextType" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "RepresentationsInContext" : {
          "type" : "IfcRepresentation",
          "reference" : true,
          "many" : true,
          "inverse" : true
        }
      }
    },
    "IfcRepresentationItem" : {
      "domain" : null,
      "superclasses" : [ "IfcLayeredItem" ],
      "fields" : {
        "LayerAssignments" : {
          "type" : "IfcPresentationLayerAssignment",
          "reference" : true,
          "many" : true,
          "inverse" : true
        },
        "StyledByItem" : {
          "type" : "IfcStyledItem",
          "reference" : true,
          "many" : true,
          "inverse" : true
        }
      }
    },
    "IfcRepresentationMap" : {
      "domain" : null,
      "superclasses" : [ ],
      "fields" : {
        "MappingOrigin" : {
          "type" : "IfcAxis2Placement",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "MappedRepresentation" : {
          "type" : "IfcRepresentation",
          "reference" : true,
          "many" : false,
          "inverse" : true
        },
        "MapUsage" : {
          "type" : "IfcMappedItem",
          "reference" : true,
          "many" : true,
          "inverse" : true
        }
      }
    },
    "IfcResource" : {
      "domain" : null,
      "superclasses" : [ "IfcObject" ],
      "fields" : {
        "ResourceOf" : {
          "type" : "IfcRelAssignsToResource",
          "reference" : true,
          "many" : true,
          "inverse" : true
        }
      }
    },
    "IfcRevolvedAreaSolid" : {
      "domain" : null,
      "superclasses" : [ "IfcSweptAreaSolid" ],
      "fields" : {
        "Axis" : {
          "type" : "IfcAxis1Placement",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "Angle" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "AngleAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcRibPlateProfileProperties" : {
      "domain" : null,
      "superclasses" : [ "IfcProfileProperties" ],
      "fields" : {
        "Thickness" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "ThicknessAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "RibHeight" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "RibHeightAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "RibWidth" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "RibWidthAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "RibSpacing" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "RibSpacingAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "Direction" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcRightCircularCone" : {
      "domain" : null,
      "superclasses" : [ "IfcCsgPrimitive3D" ],
      "fields" : {
        "Height" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "HeightAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "BottomRadius" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "BottomRadiusAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcRightCircularCylinder" : {
      "domain" : null,
      "superclasses" : [ "IfcCsgPrimitive3D" ],
      "fields" : {
        "Height" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "HeightAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "Radius" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "RadiusAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcRoof" : {
      "domain" : null,
      "superclasses" : [ "IfcBuildingElement" ],
      "fields" : {
        "ShapeType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcRoot" : {
      "domain" : null,
      "superclasses" : [ ],
      "fields" : {
        "GlobalId" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "OwnerHistory" : {
          "type" : "IfcOwnerHistory",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "Name" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "Description" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcRoundedEdgeFeature" : {
      "domain" : null,
      "superclasses" : [ "IfcEdgeFeature" ],
      "fields" : {
        "Radius" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "RadiusAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcRoundedRectangleProfileDef" : {
      "domain" : null,
      "superclasses" : [ "IfcRectangleProfileDef" ],
      "fields" : {
        "RoundingRadius" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "RoundingRadiusAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcSIUnit" : {
      "domain" : null,
      "superclasses" : [ "IfcNamedUnit" ],
      "fields" : {
        "Prefix" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "Name" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcSanitaryTerminalType" : {
      "domain" : null,
      "superclasses" : [ "IfcFlowTerminalType" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcScheduleTimeControl" : {
      "domain" : null,
      "superclasses" : [ "IfcControl" ],
      "fields" : {
        "ActualStart" : {
          "type" : "IfcDateTimeSelect",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "EarlyStart" : {
          "type" : "IfcDateTimeSelect",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "LateStart" : {
          "type" : "IfcDateTimeSelect",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "ScheduleStart" : {
          "type" : "IfcDateTimeSelect",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "ActualFinish" : {
          "type" : "IfcDateTimeSelect",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "EarlyFinish" : {
          "type" : "IfcDateTimeSelect",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "LateFinish" : {
          "type" : "IfcDateTimeSelect",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "ScheduleFinish" : {
          "type" : "IfcDateTimeSelect",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "ScheduleDuration" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "ScheduleDurationAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "ActualDuration" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "ActualDurationAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "RemainingTime" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "RemainingTimeAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "FreeFloat" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "FreeFloatAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "TotalFloat" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "TotalFloatAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "IsCritical" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "StatusTime" : {
          "type" : "IfcDateTimeSelect",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "StartFloat" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "StartFloatAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "FinishFloat" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "FinishFloatAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "Completion" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "CompletionAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "ScheduleTimeControlAssigned" : {
          "type" : "IfcRelAssignsTasks",
          "reference" : true,
          "many" : false,
          "inverse" : true
        }
      }
    },
    "IfcSectionProperties" : {
      "domain" : null,
      "superclasses" : [ ],
      "fields" : {
        "SectionType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "StartProfile" : {
          "type" : "IfcProfileDef",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "EndProfile" : {
          "type" : "IfcProfileDef",
          "reference" : true,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcSectionReinforcementProperties" : {
      "domain" : null,
      "superclasses" : [ ],
      "fields" : {
        "LongitudinalStartPosition" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "LongitudinalStartPositionAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "LongitudinalEndPosition" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "LongitudinalEndPositionAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "TransversePosition" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "TransversePositionAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "ReinforcementRole" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "SectionDefinition" : {
          "type" : "IfcSectionProperties",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "CrossSectionReinforcementDefinitions" : {
          "type" : "IfcReinforcementBarProperties",
          "reference" : true,
          "many" : true,
          "inverse" : false
        }
      }
    },
    "IfcSectionedSpine" : {
      "domain" : null,
      "superclasses" : [ "IfcGeometricRepresentationItem" ],
      "fields" : {
        "SpineCurve" : {
          "type" : "IfcCompositeCurve",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "CrossSections" : {
          "type" : "IfcProfileDef",
          "reference" : true,
          "many" : true,
          "inverse" : false
        },
        "CrossSectionPositions" : {
          "type" : "IfcAxis2Placement3D",
          "reference" : true,
          "many" : true,
          "inverse" : false
        },
        "Dim" : {
          "type" : "long",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcSensorType" : {
      "domain" : null,
      "superclasses" : [ "IfcDistributionControlElementType" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcServiceLife" : {
      "domain" : null,
      "superclasses" : [ "IfcControl" ],
      "fields" : {
        "ServiceLifeType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "ServiceLifeDuration" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "ServiceLifeDurationAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcServiceLifeFactor" : {
      "domain" : null,
      "superclasses" : [ "IfcPropertySetDefinition" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "UpperValue" : {
          "type" : "IfcMeasureValue",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "MostUsedValue" : {
          "type" : "IfcMeasureValue",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "LowerValue" : {
          "type" : "IfcMeasureValue",
          "reference" : true,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcShapeAspect" : {
      "domain" : null,
      "superclasses" : [ ],
      "fields" : {
        "ShapeRepresentations" : {
          "type" : "IfcShapeModel",
          "reference" : true,
          "many" : true,
          "inverse" : true
        },
        "Name" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "Description" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "ProductDefinitional" : {
          "type" : "boolean",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "PartOfProductDefinitionShape" : {
          "type" : "IfcProductDefinitionShape",
          "reference" : true,
          "many" : false,
          "inverse" : true
        }
      }
    },
    "IfcShapeModel" : {
      "domain" : null,
      "superclasses" : [ "IfcRepresentation" ],
      "fields" : {
        "OfShapeAspect" : {
          "type" : "IfcShapeAspect",
          "reference" : true,
          "many" : true,
          "inverse" : true
        }
      }
    },
    "IfcShapeRepresentation" : {
      "domain" : null,
      "superclasses" : [ "IfcShapeModel" ],
      "fields" : { }
    },
    "IfcShellBasedSurfaceModel" : {
      "domain" : null,
      "superclasses" : [ "IfcGeometricRepresentationItem" ],
      "fields" : {
        "SbsmBoundary" : {
          "type" : "IfcShell",
          "reference" : true,
          "many" : true,
          "inverse" : false
        },
        "Dim" : {
          "type" : "long",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcSimpleProperty" : {
      "domain" : null,
      "superclasses" : [ "IfcProperty" ],
      "fields" : { }
    },
    "IfcSite" : {
      "domain" : null,
      "superclasses" : [ "IfcSpatialStructureElement" ],
      "fields" : {
        "RefLatitude" : {
          "type" : "long",
          "reference" : false,
          "many" : true,
          "inverse" : false
        },
        "RefLongitude" : {
          "type" : "long",
          "reference" : false,
          "many" : true,
          "inverse" : false
        },
        "RefElevation" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "RefElevationAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "LandTitleNumber" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "SiteAddress" : {
          "type" : "IfcPostalAddress",
          "reference" : true,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcSlab" : {
      "domain" : null,
      "superclasses" : [ "IfcBuildingElement" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcSlabType" : {
      "domain" : null,
      "superclasses" : [ "IfcBuildingElementType" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcSlippageConnectionCondition" : {
      "domain" : null,
      "superclasses" : [ "IfcStructuralConnectionCondition" ],
      "fields" : {
        "SlippageX" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "SlippageXAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "SlippageY" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "SlippageYAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "SlippageZ" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "SlippageZAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcSolidModel" : {
      "domain" : null,
      "superclasses" : [ "IfcGeometricRepresentationItem", "IfcBooleanOperand" ],
      "fields" : {
        "Dim" : {
          "type" : "long",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcSoundProperties" : {
      "domain" : null,
      "superclasses" : [ "IfcPropertySetDefinition" ],
      "fields" : {
        "IsAttenuating" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "SoundScale" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "SoundValues" : {
          "type" : "IfcSoundValue",
          "reference" : true,
          "many" : true,
          "inverse" : false
        }
      }
    },
    "IfcSoundValue" : {
      "domain" : null,
      "superclasses" : [ "IfcPropertySetDefinition" ],
      "fields" : {
        "SoundLevelTimeSeries" : {
          "type" : "IfcTimeSeries",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "Frequency" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "FrequencyAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "SoundLevelSingleValue" : {
          "type" : "IfcDerivedMeasureValue",
          "reference" : true,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcSpace" : {
      "domain" : null,
      "superclasses" : [ "IfcSpatialStructureElement" ],
      "fields" : {
        "InteriorOrExteriorSpace" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "ElevationWithFlooring" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "ElevationWithFlooringAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "HasCoverings" : {
          "type" : "IfcRelCoversSpaces",
          "reference" : true,
          "many" : true,
          "inverse" : true
        },
        "BoundedBy" : {
          "type" : "IfcRelSpaceBoundary",
          "reference" : true,
          "many" : true,
          "inverse" : true
        }
      }
    },
    "IfcSpaceHeaterType" : {
      "domain" : null,
      "superclasses" : [ "IfcEnergyConversionDeviceType" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcSpaceProgram" : {
      "domain" : null,
      "superclasses" : [ "IfcControl" ],
      "fields" : {
        "SpaceProgramIdentifier" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "MaxRequiredArea" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "MaxRequiredAreaAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "MinRequiredArea" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "MinRequiredAreaAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "RequestedLocation" : {
          "type" : "IfcSpatialStructureElement",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "StandardRequiredArea" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "StandardRequiredAreaAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "HasInteractionReqsFrom" : {
          "type" : "IfcRelInteractionRequirements",
          "reference" : true,
          "many" : true,
          "inverse" : true
        },
        "HasInteractionReqsTo" : {
          "type" : "IfcRelInteractionRequirements",
          "reference" : true,
          "many" : true,
          "inverse" : true
        }
      }
    },
    "IfcSpaceThermalLoadProperties" : {
      "domain" : null,
      "superclasses" : [ "IfcPropertySetDefinition" ],
      "fields" : {
        "ApplicableValueRatio" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "ApplicableValueRatioAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "ThermalLoadSource" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "PropertySource" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "SourceDescription" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "MaximumValue" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "MaximumValueAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "MinimumValue" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "MinimumValueAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "ThermalLoadTimeSeriesValues" : {
          "type" : "IfcTimeSeries",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "UserDefinedThermalLoadSource" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "UserDefinedPropertySource" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "ThermalLoadType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcSpaceType" : {
      "domain" : null,
      "superclasses" : [ "IfcSpatialStructureElementType" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcSpatialStructureElement" : {
      "domain" : null,
      "superclasses" : [ "IfcProduct" ],
      "fields" : {
        "LongName" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "CompositionType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "ReferencesElements" : {
          "type" : "IfcRelReferencedInSpatialStructure",
          "reference" : true,
          "many" : true,
          "inverse" : true
        },
        "ServicedBySystems" : {
          "type" : "IfcRelServicesBuildings",
          "reference" : true,
          "many" : true,
          "inverse" : true
        },
        "ContainsElements" : {
          "type" : "IfcRelContainedInSpatialStructure",
          "reference" : true,
          "many" : true,
          "inverse" : true
        }
      }
    },
    "IfcSpatialStructureElementType" : {
      "domain" : null,
      "superclasses" : [ "IfcElementType" ],
      "fields" : { }
    },
    "IfcSphere" : {
      "domain" : null,
      "superclasses" : [ "IfcCsgPrimitive3D" ],
      "fields" : {
        "Radius" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "RadiusAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcStackTerminalType" : {
      "domain" : null,
      "superclasses" : [ "IfcFlowTerminalType" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcStair" : {
      "domain" : null,
      "superclasses" : [ "IfcBuildingElement" ],
      "fields" : {
        "ShapeType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcStairFlight" : {
      "domain" : null,
      "superclasses" : [ "IfcBuildingElement" ],
      "fields" : {
        "NumberOfRiser" : {
          "type" : "long",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "NumberOfTreads" : {
          "type" : "long",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "RiserHeight" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "RiserHeightAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "TreadLength" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "TreadLengthAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcStairFlightType" : {
      "domain" : null,
      "superclasses" : [ "IfcBuildingElementType" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcStructuralAction" : {
      "domain" : null,
      "superclasses" : [ "IfcStructuralActivity" ],
      "fields" : {
        "DestabilizingLoad" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "CausedBy" : {
          "type" : "IfcStructuralReaction",
          "reference" : true,
          "many" : false,
          "inverse" : true
        }
      }
    },
    "IfcStructuralActivity" : {
      "domain" : null,
      "superclasses" : [ "IfcProduct" ],
      "fields" : {
        "AppliedLoad" : {
          "type" : "IfcStructuralLoad",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "GlobalOrLocal" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "AssignedToStructuralItem" : {
          "type" : "IfcRelConnectsStructuralActivity",
          "reference" : true,
          "many" : false,
          "inverse" : true
        }
      }
    },
    "IfcStructuralAnalysisModel" : {
      "domain" : null,
      "superclasses" : [ "IfcSystem" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "OrientationOf2DPlane" : {
          "type" : "IfcAxis2Placement3D",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "LoadedBy" : {
          "type" : "IfcStructuralLoadGroup",
          "reference" : true,
          "many" : true,
          "inverse" : true
        },
        "HasResults" : {
          "type" : "IfcStructuralResultGroup",
          "reference" : true,
          "many" : true,
          "inverse" : true
        }
      }
    },
    "IfcStructuralConnection" : {
      "domain" : null,
      "superclasses" : [ "IfcStructuralItem" ],
      "fields" : {
        "AppliedCondition" : {
          "type" : "IfcBoundaryCondition",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "ConnectsStructuralMembers" : {
          "type" : "IfcRelConnectsStructuralMember",
          "reference" : true,
          "many" : true,
          "inverse" : true
        }
      }
    },
    "IfcStructuralConnectionCondition" : {
      "domain" : null,
      "superclasses" : [ ],
      "fields" : {
        "Name" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcStructuralCurveConnection" : {
      "domain" : null,
      "superclasses" : [ "IfcStructuralConnection" ],
      "fields" : { }
    },
    "IfcStructuralCurveMember" : {
      "domain" : null,
      "superclasses" : [ "IfcStructuralMember" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcStructuralCurveMemberVarying" : {
      "domain" : null,
      "superclasses" : [ "IfcStructuralCurveMember" ],
      "fields" : { }
    },
    "IfcStructuralItem" : {
      "domain" : null,
      "superclasses" : [ "IfcProduct", "IfcStructuralActivityAssignmentSelect" ],
      "fields" : {
        "AssignedStructuralActivity" : {
          "type" : "IfcRelConnectsStructuralActivity",
          "reference" : true,
          "many" : true,
          "inverse" : true
        }
      }
    },
    "IfcStructuralLinearAction" : {
      "domain" : null,
      "superclasses" : [ "IfcStructuralAction" ],
      "fields" : {
        "ProjectedOrTrue" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcStructuralLinearActionVarying" : {
      "domain" : null,
      "superclasses" : [ "IfcStructuralLinearAction" ],
      "fields" : {
        "VaryingAppliedLoadLocation" : {
          "type" : "IfcShapeAspect",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "SubsequentAppliedLoads" : {
          "type" : "IfcStructuralLoad",
          "reference" : true,
          "many" : true,
          "inverse" : false
        }
      }
    },
    "IfcStructuralLoad" : {
      "domain" : null,
      "superclasses" : [ ],
      "fields" : {
        "Name" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcStructuralLoadGroup" : {
      "domain" : null,
      "superclasses" : [ "IfcGroup" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "ActionType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "ActionSource" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "Coefficient" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "CoefficientAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "Purpose" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "SourceOfResultGroup" : {
          "type" : "IfcStructuralResultGroup",
          "reference" : true,
          "many" : true,
          "inverse" : true
        },
        "LoadGroupFor" : {
          "type" : "IfcStructuralAnalysisModel",
          "reference" : true,
          "many" : true,
          "inverse" : true
        }
      }
    },
    "IfcStructuralLoadLinearForce" : {
      "domain" : null,
      "superclasses" : [ "IfcStructuralLoadStatic" ],
      "fields" : {
        "LinearForceX" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "LinearForceXAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "LinearForceY" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "LinearForceYAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "LinearForceZ" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "LinearForceZAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "LinearMomentX" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "LinearMomentXAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "LinearMomentY" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "LinearMomentYAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "LinearMomentZ" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "LinearMomentZAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcStructuralLoadPlanarForce" : {
      "domain" : null,
      "superclasses" : [ "IfcStructuralLoadStatic" ],
      "fields" : {
        "PlanarForceX" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "PlanarForceXAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "PlanarForceY" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "PlanarForceYAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "PlanarForceZ" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "PlanarForceZAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcStructuralLoadSingleDisplacement" : {
      "domain" : null,
      "superclasses" : [ "IfcStructuralLoadStatic" ],
      "fields" : {
        "DisplacementX" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "DisplacementXAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "DisplacementY" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "DisplacementYAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "DisplacementZ" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "DisplacementZAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "RotationalDisplacementRX" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "RotationalDisplacementRXAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "RotationalDisplacementRY" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "RotationalDisplacementRYAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "RotationalDisplacementRZ" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "RotationalDisplacementRZAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcStructuralLoadSingleDisplacementDistortion" : {
      "domain" : null,
      "superclasses" : [ "IfcStructuralLoadSingleDisplacement" ],
      "fields" : {
        "Distortion" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "DistortionAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcStructuralLoadSingleForce" : {
      "domain" : null,
      "superclasses" : [ "IfcStructuralLoadStatic" ],
      "fields" : {
        "ForceX" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "ForceXAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "ForceY" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "ForceYAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "ForceZ" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "ForceZAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "MomentX" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "MomentXAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "MomentY" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "MomentYAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "MomentZ" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "MomentZAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcStructuralLoadSingleForceWarping" : {
      "domain" : null,
      "superclasses" : [ "IfcStructuralLoadSingleForce" ],
      "fields" : {
        "WarpingMoment" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "WarpingMomentAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcStructuralLoadStatic" : {
      "domain" : null,
      "superclasses" : [ "IfcStructuralLoad" ],
      "fields" : { }
    },
    "IfcStructuralLoadTemperature" : {
      "domain" : null,
      "superclasses" : [ "IfcStructuralLoadStatic" ],
      "fields" : {
        "DeltaT_Constant" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "DeltaT_ConstantAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "DeltaT_Y" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "DeltaT_YAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "DeltaT_Z" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "DeltaT_ZAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcStructuralMember" : {
      "domain" : null,
      "superclasses" : [ "IfcStructuralItem" ],
      "fields" : {
        "ReferencesElement" : {
          "type" : "IfcRelConnectsStructuralElement",
          "reference" : true,
          "many" : true,
          "inverse" : true
        },
        "ConnectedBy" : {
          "type" : "IfcRelConnectsStructuralMember",
          "reference" : true,
          "many" : true,
          "inverse" : true
        }
      }
    },
    "IfcStructuralPlanarAction" : {
      "domain" : null,
      "superclasses" : [ "IfcStructuralAction" ],
      "fields" : {
        "ProjectedOrTrue" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcStructuralPlanarActionVarying" : {
      "domain" : null,
      "superclasses" : [ "IfcStructuralPlanarAction" ],
      "fields" : {
        "VaryingAppliedLoadLocation" : {
          "type" : "IfcShapeAspect",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "SubsequentAppliedLoads" : {
          "type" : "IfcStructuralLoad",
          "reference" : true,
          "many" : true,
          "inverse" : false
        }
      }
    },
    "IfcStructuralPointAction" : {
      "domain" : null,
      "superclasses" : [ "IfcStructuralAction" ],
      "fields" : { }
    },
    "IfcStructuralPointConnection" : {
      "domain" : null,
      "superclasses" : [ "IfcStructuralConnection" ],
      "fields" : { }
    },
    "IfcStructuralPointReaction" : {
      "domain" : null,
      "superclasses" : [ "IfcStructuralReaction" ],
      "fields" : { }
    },
    "IfcStructuralProfileProperties" : {
      "domain" : null,
      "superclasses" : [ "IfcGeneralProfileProperties" ],
      "fields" : {
        "TorsionalConstantX" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "TorsionalConstantXAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "MomentOfInertiaYZ" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "MomentOfInertiaYZAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "MomentOfInertiaY" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "MomentOfInertiaYAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "MomentOfInertiaZ" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "MomentOfInertiaZAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "WarpingConstant" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "WarpingConstantAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "ShearCentreZ" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "ShearCentreZAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "ShearCentreY" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "ShearCentreYAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "ShearDeformationAreaZ" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "ShearDeformationAreaZAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "ShearDeformationAreaY" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "ShearDeformationAreaYAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "MaximumSectionModulusY" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "MaximumSectionModulusYAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "MinimumSectionModulusY" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "MinimumSectionModulusYAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "MaximumSectionModulusZ" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "MaximumSectionModulusZAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "MinimumSectionModulusZ" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "MinimumSectionModulusZAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "TorsionalSectionModulus" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "TorsionalSectionModulusAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "CentreOfGravityInX" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "CentreOfGravityInXAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "CentreOfGravityInY" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "CentreOfGravityInYAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcStructuralReaction" : {
      "domain" : null,
      "superclasses" : [ "IfcStructuralActivity" ],
      "fields" : {
        "Causes" : {
          "type" : "IfcStructuralAction",
          "reference" : true,
          "many" : true,
          "inverse" : true
        }
      }
    },
    "IfcStructuralResultGroup" : {
      "domain" : null,
      "superclasses" : [ "IfcGroup" ],
      "fields" : {
        "TheoryType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "ResultForLoadGroup" : {
          "type" : "IfcStructuralLoadGroup",
          "reference" : true,
          "many" : false,
          "inverse" : true
        },
        "IsLinear" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "ResultGroupFor" : {
          "type" : "IfcStructuralAnalysisModel",
          "reference" : true,
          "many" : true,
          "inverse" : true
        }
      }
    },
    "IfcStructuralSteelProfileProperties" : {
      "domain" : null,
      "superclasses" : [ "IfcStructuralProfileProperties" ],
      "fields" : {
        "ShearAreaZ" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "ShearAreaZAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "ShearAreaY" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "ShearAreaYAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "PlasticShapeFactorY" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "PlasticShapeFactorYAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "PlasticShapeFactorZ" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "PlasticShapeFactorZAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcStructuralSurfaceConnection" : {
      "domain" : null,
      "superclasses" : [ "IfcStructuralConnection" ],
      "fields" : { }
    },
    "IfcStructuralSurfaceMember" : {
      "domain" : null,
      "superclasses" : [ "IfcStructuralMember" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "Thickness" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "ThicknessAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcStructuralSurfaceMemberVarying" : {
      "domain" : null,
      "superclasses" : [ "IfcStructuralSurfaceMember" ],
      "fields" : {
        "SubsequentThickness" : {
          "type" : "double",
          "reference" : false,
          "many" : true,
          "inverse" : false
        },
        "SubsequentThicknessAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : true,
          "inverse" : false
        },
        "VaryingThicknessLocation" : {
          "type" : "IfcShapeAspect",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "VaryingThickness" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "VaryingThicknessAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcStructuredDimensionCallout" : {
      "domain" : null,
      "superclasses" : [ "IfcDraughtingCallout" ],
      "fields" : { }
    },
    "IfcStyleModel" : {
      "domain" : null,
      "superclasses" : [ "IfcRepresentation" ],
      "fields" : { }
    },
    "IfcStyledItem" : {
      "domain" : null,
      "superclasses" : [ "IfcRepresentationItem" ],
      "fields" : {
        "Item" : {
          "type" : "IfcRepresentationItem",
          "reference" : true,
          "many" : false,
          "inverse" : true
        },
        "Styles" : {
          "type" : "IfcPresentationStyleAssignment",
          "reference" : true,
          "many" : true,
          "inverse" : false
        },
        "Name" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcStyledRepresentation" : {
      "domain" : null,
      "superclasses" : [ "IfcStyleModel" ],
      "fields" : { }
    },
    "IfcSubContractResource" : {
      "domain" : null,
      "superclasses" : [ "IfcConstructionResource" ],
      "fields" : {
        "SubContractor" : {
          "type" : "IfcActorSelect",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "JobDescription" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcSubedge" : {
      "domain" : null,
      "superclasses" : [ "IfcEdge" ],
      "fields" : {
        "ParentEdge" : {
          "type" : "IfcEdge",
          "reference" : true,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcSurface" : {
      "domain" : null,
      "superclasses" : [ "IfcGeometricRepresentationItem", "IfcGeometricSetSelect", "IfcSurfaceOrFaceSurface" ],
      "fields" : { }
    },
    "IfcSurfaceCurveSweptAreaSolid" : {
      "domain" : null,
      "superclasses" : [ "IfcSweptAreaSolid" ],
      "fields" : {
        "Directrix" : {
          "type" : "IfcCurve",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "StartParam" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "StartParamAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "EndParam" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "EndParamAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "ReferenceSurface" : {
          "type" : "IfcSurface",
          "reference" : true,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcSurfaceOfLinearExtrusion" : {
      "domain" : null,
      "superclasses" : [ "IfcSweptSurface" ],
      "fields" : {
        "ExtrudedDirection" : {
          "type" : "IfcDirection",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "Depth" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "DepthAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcSurfaceOfRevolution" : {
      "domain" : null,
      "superclasses" : [ "IfcSweptSurface" ],
      "fields" : {
        "AxisPosition" : {
          "type" : "IfcAxis1Placement",
          "reference" : true,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcSurfaceStyle" : {
      "domain" : null,
      "superclasses" : [ "IfcPresentationStyle", "IfcPresentationStyleSelect" ],
      "fields" : {
        "Side" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "Styles" : {
          "type" : "IfcSurfaceStyleElementSelect",
          "reference" : true,
          "many" : true,
          "inverse" : false
        }
      }
    },
    "IfcSurfaceStyleLighting" : {
      "domain" : null,
      "superclasses" : [ "IfcSurfaceStyleElementSelect" ],
      "fields" : {
        "DiffuseTransmissionColour" : {
          "type" : "IfcColourRgb",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "DiffuseReflectionColour" : {
          "type" : "IfcColourRgb",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "TransmissionColour" : {
          "type" : "IfcColourRgb",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "ReflectanceColour" : {
          "type" : "IfcColourRgb",
          "reference" : true,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcSurfaceStyleRefraction" : {
      "domain" : null,
      "superclasses" : [ "IfcSurfaceStyleElementSelect" ],
      "fields" : {
        "RefractionIndex" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "RefractionIndexAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "DispersionFactor" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "DispersionFactorAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcSurfaceStyleRendering" : {
      "domain" : null,
      "superclasses" : [ "IfcSurfaceStyleShading" ],
      "fields" : {
        "Transparency" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "TransparencyAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "DiffuseColour" : {
          "type" : "IfcColourOrFactor",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "TransmissionColour" : {
          "type" : "IfcColourOrFactor",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "DiffuseTransmissionColour" : {
          "type" : "IfcColourOrFactor",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "ReflectionColour" : {
          "type" : "IfcColourOrFactor",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "SpecularColour" : {
          "type" : "IfcColourOrFactor",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "SpecularHighlight" : {
          "type" : "IfcSpecularHighlightSelect",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "ReflectanceMethod" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcSurfaceStyleShading" : {
      "domain" : null,
      "superclasses" : [ "IfcSurfaceStyleElementSelect" ],
      "fields" : {
        "SurfaceColour" : {
          "type" : "IfcColourRgb",
          "reference" : true,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcSurfaceStyleWithTextures" : {
      "domain" : null,
      "superclasses" : [ "IfcSurfaceStyleElementSelect" ],
      "fields" : {
        "Textures" : {
          "type" : "IfcSurfaceTexture",
          "reference" : true,
          "many" : true,
          "inverse" : false
        }
      }
    },
    "IfcSurfaceTexture" : {
      "domain" : null,
      "superclasses" : [ ],
      "fields" : {
        "RepeatS" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "RepeatT" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "TextureType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "TextureTransform" : {
          "type" : "IfcCartesianTransformationOperator2D",
          "reference" : true,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcSweptAreaSolid" : {
      "domain" : null,
      "superclasses" : [ "IfcSolidModel" ],
      "fields" : {
        "SweptArea" : {
          "type" : "IfcProfileDef",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "Position" : {
          "type" : "IfcAxis2Placement3D",
          "reference" : true,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcSweptDiskSolid" : {
      "domain" : null,
      "superclasses" : [ "IfcSolidModel" ],
      "fields" : {
        "Directrix" : {
          "type" : "IfcCurve",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "Radius" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "RadiusAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "InnerRadius" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "InnerRadiusAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "StartParam" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "StartParamAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "EndParam" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "EndParamAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcSweptSurface" : {
      "domain" : null,
      "superclasses" : [ "IfcSurface" ],
      "fields" : {
        "SweptCurve" : {
          "type" : "IfcProfileDef",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "Position" : {
          "type" : "IfcAxis2Placement3D",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "Dim" : {
          "type" : "long",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcSwitchingDeviceType" : {
      "domain" : null,
      "superclasses" : [ "IfcFlowControllerType" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcSymbolStyle" : {
      "domain" : null,
      "superclasses" : [ "IfcPresentationStyle", "IfcPresentationStyleSelect" ],
      "fields" : {
        "StyleOfSymbol" : {
          "type" : "IfcSymbolStyleSelect",
          "reference" : true,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcSystem" : {
      "domain" : null,
      "superclasses" : [ "IfcGroup" ],
      "fields" : {
        "ServicesBuildings" : {
          "type" : "IfcRelServicesBuildings",
          "reference" : true,
          "many" : true,
          "inverse" : true
        }
      }
    },
    "IfcSystemFurnitureElementType" : {
      "domain" : null,
      "superclasses" : [ "IfcFurnishingElementType" ],
      "fields" : { }
    },
    "IfcTShapeProfileDef" : {
      "domain" : null,
      "superclasses" : [ "IfcParameterizedProfileDef" ],
      "fields" : {
        "Depth" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "DepthAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "FlangeWidth" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "FlangeWidthAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "WebThickness" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "WebThicknessAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "FlangeThickness" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "FlangeThicknessAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "FilletRadius" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "FilletRadiusAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "FlangeEdgeRadius" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "FlangeEdgeRadiusAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "WebEdgeRadius" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "WebEdgeRadiusAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "WebSlope" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "WebSlopeAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "FlangeSlope" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "FlangeSlopeAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "CentreOfGravityInY" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "CentreOfGravityInYAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcTable" : {
      "domain" : null,
      "superclasses" : [ "IfcMetricValueSelect" ],
      "fields" : {
        "Name" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "Rows" : {
          "type" : "IfcTableRow",
          "reference" : true,
          "many" : true,
          "inverse" : true
        }
      }
    },
    "IfcTableRow" : {
      "domain" : null,
      "superclasses" : [ ],
      "fields" : {
        "RowCells" : {
          "type" : "IfcValue",
          "reference" : true,
          "many" : true,
          "inverse" : false
        },
        "IsHeading" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "OfTable" : {
          "type" : "IfcTable",
          "reference" : true,
          "many" : false,
          "inverse" : true
        }
      }
    },
    "IfcTankType" : {
      "domain" : null,
      "superclasses" : [ "IfcFlowStorageDeviceType" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcTask" : {
      "domain" : null,
      "superclasses" : [ "IfcProcess" ],
      "fields" : {
        "TaskId" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "Status" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "WorkMethod" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "IsMilestone" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "Priority" : {
          "type" : "long",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcTelecomAddress" : {
      "domain" : null,
      "superclasses" : [ "IfcAddress" ],
      "fields" : {
        "TelephoneNumbers" : {
          "type" : "string",
          "reference" : false,
          "many" : true,
          "inverse" : false
        },
        "FacsimileNumbers" : {
          "type" : "string",
          "reference" : false,
          "many" : true,
          "inverse" : false
        },
        "PagerNumber" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "ElectronicMailAddresses" : {
          "type" : "string",
          "reference" : false,
          "many" : true,
          "inverse" : false
        },
        "WWWHomePageURL" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcTendon" : {
      "domain" : null,
      "superclasses" : [ "IfcReinforcingElement" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "NominalDiameter" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "NominalDiameterAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "CrossSectionArea" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "CrossSectionAreaAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "TensionForce" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "TensionForceAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "PreStress" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "PreStressAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "FrictionCoefficient" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "FrictionCoefficientAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "AnchorageSlip" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "AnchorageSlipAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "MinCurvatureRadius" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "MinCurvatureRadiusAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcTendonAnchor" : {
      "domain" : null,
      "superclasses" : [ "IfcReinforcingElement" ],
      "fields" : { }
    },
    "IfcTerminatorSymbol" : {
      "domain" : null,
      "superclasses" : [ "IfcAnnotationSymbolOccurrence" ],
      "fields" : {
        "AnnotatedCurve" : {
          "type" : "IfcAnnotationCurveOccurrence",
          "reference" : true,
          "many" : false,
          "inverse" : true
        }
      }
    },
    "IfcTextLiteral" : {
      "domain" : null,
      "superclasses" : [ "IfcGeometricRepresentationItem" ],
      "fields" : {
        "Literal" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "Placement" : {
          "type" : "IfcAxis2Placement",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "Path" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcTextLiteralWithExtent" : {
      "domain" : null,
      "superclasses" : [ "IfcTextLiteral" ],
      "fields" : {
        "Extent" : {
          "type" : "IfcPlanarExtent",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "BoxAlignment" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcTextStyle" : {
      "domain" : null,
      "superclasses" : [ "IfcPresentationStyle", "IfcPresentationStyleSelect" ],
      "fields" : {
        "TextCharacterAppearance" : {
          "type" : "IfcCharacterStyleSelect",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "TextStyle" : {
          "type" : "IfcTextStyleSelect",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "TextFontStyle" : {
          "type" : "IfcTextFontSelect",
          "reference" : true,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcTextStyleFontModel" : {
      "domain" : null,
      "superclasses" : [ "IfcPreDefinedTextFont" ],
      "fields" : {
        "FontFamily" : {
          "type" : "string",
          "reference" : false,
          "many" : true,
          "inverse" : false
        },
        "FontStyle" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "FontVariant" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "FontWeight" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "FontSize" : {
          "type" : "IfcSizeSelect",
          "reference" : true,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcTextStyleForDefinedFont" : {
      "domain" : null,
      "superclasses" : [ "IfcCharacterStyleSelect" ],
      "fields" : {
        "Colour" : {
          "type" : "IfcColour",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "BackgroundColour" : {
          "type" : "IfcColour",
          "reference" : true,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcTextStyleTextModel" : {
      "domain" : null,
      "superclasses" : [ "IfcTextStyleSelect" ],
      "fields" : {
        "TextIndent" : {
          "type" : "IfcSizeSelect",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "TextAlign" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "TextDecoration" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "LetterSpacing" : {
          "type" : "IfcSizeSelect",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "WordSpacing" : {
          "type" : "IfcSizeSelect",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "TextTransform" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "LineHeight" : {
          "type" : "IfcSizeSelect",
          "reference" : true,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcTextStyleWithBoxCharacteristics" : {
      "domain" : null,
      "superclasses" : [ "IfcTextStyleSelect" ],
      "fields" : {
        "BoxHeight" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "BoxHeightAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "BoxWidth" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "BoxWidthAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "BoxSlantAngle" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "BoxSlantAngleAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "BoxRotateAngle" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "BoxRotateAngleAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "CharacterSpacing" : {
          "type" : "IfcSizeSelect",
          "reference" : true,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcTextureCoordinate" : {
      "domain" : null,
      "superclasses" : [ ],
      "fields" : {
        "AnnotatedSurface" : {
          "type" : "IfcAnnotationSurface",
          "reference" : true,
          "many" : true,
          "inverse" : true
        }
      }
    },
    "IfcTextureCoordinateGenerator" : {
      "domain" : null,
      "superclasses" : [ "IfcTextureCoordinate" ],
      "fields" : {
        "Mode" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "Parameter" : {
          "type" : "IfcSimpleValue",
          "reference" : true,
          "many" : true,
          "inverse" : false
        }
      }
    },
    "IfcTextureMap" : {
      "domain" : null,
      "superclasses" : [ "IfcTextureCoordinate" ],
      "fields" : {
        "TextureMaps" : {
          "type" : "IfcVertexBasedTextureMap",
          "reference" : true,
          "many" : true,
          "inverse" : false
        }
      }
    },
    "IfcTextureVertex" : {
      "domain" : null,
      "superclasses" : [ ],
      "fields" : {
        "Coordinates" : {
          "type" : "double",
          "reference" : false,
          "many" : true,
          "inverse" : false
        },
        "CoordinatesAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : true,
          "inverse" : false
        }
      }
    },
    "IfcThermalMaterialProperties" : {
      "domain" : null,
      "superclasses" : [ "IfcMaterialProperties" ],
      "fields" : {
        "SpecificHeatCapacity" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "SpecificHeatCapacityAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "BoilingPoint" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "BoilingPointAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "FreezingPoint" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "FreezingPointAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "ThermalConductivity" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "ThermalConductivityAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcTimeSeries" : {
      "domain" : null,
      "superclasses" : [ "IfcMetricValueSelect", "IfcObjectReferenceSelect" ],
      "fields" : {
        "Name" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "Description" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "StartTime" : {
          "type" : "IfcDateTimeSelect",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "EndTime" : {
          "type" : "IfcDateTimeSelect",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "TimeSeriesDataType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "DataOrigin" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "UserDefinedDataOrigin" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "Unit" : {
          "type" : "IfcUnit",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "DocumentedBy" : {
          "type" : "IfcTimeSeriesReferenceRelationship",
          "reference" : true,
          "many" : true,
          "inverse" : true
        }
      }
    },
    "IfcTimeSeriesReferenceRelationship" : {
      "domain" : null,
      "superclasses" : [ ],
      "fields" : {
        "ReferencedTimeSeries" : {
          "type" : "IfcTimeSeries",
          "reference" : true,
          "many" : false,
          "inverse" : true
        },
        "TimeSeriesReferences" : {
          "type" : "IfcDocumentSelect",
          "reference" : true,
          "many" : true,
          "inverse" : false
        }
      }
    },
    "IfcTimeSeriesSchedule" : {
      "domain" : null,
      "superclasses" : [ "IfcControl" ],
      "fields" : {
        "ApplicableDates" : {
          "type" : "IfcDateTimeSelect",
          "reference" : true,
          "many" : true,
          "inverse" : false
        },
        "TimeSeriesScheduleType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "TimeSeries" : {
          "type" : "IfcTimeSeries",
          "reference" : true,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcTimeSeriesValue" : {
      "domain" : null,
      "superclasses" : [ ],
      "fields" : {
        "ListValues" : {
          "type" : "IfcValue",
          "reference" : true,
          "many" : true,
          "inverse" : false
        }
      }
    },
    "IfcTopologicalRepresentationItem" : {
      "domain" : null,
      "superclasses" : [ "IfcRepresentationItem" ],
      "fields" : { }
    },
    "IfcTopologyRepresentation" : {
      "domain" : null,
      "superclasses" : [ "IfcShapeModel" ],
      "fields" : { }
    },
    "IfcTransformerType" : {
      "domain" : null,
      "superclasses" : [ "IfcEnergyConversionDeviceType" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcTransportElement" : {
      "domain" : null,
      "superclasses" : [ "IfcElement" ],
      "fields" : {
        "OperationType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "CapacityByWeight" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "CapacityByWeightAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "CapacityByNumber" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "CapacityByNumberAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcTransportElementType" : {
      "domain" : null,
      "superclasses" : [ "IfcElementType" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcTrapeziumProfileDef" : {
      "domain" : null,
      "superclasses" : [ "IfcParameterizedProfileDef" ],
      "fields" : {
        "BottomXDim" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "BottomXDimAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "TopXDim" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "TopXDimAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "YDim" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "YDimAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "TopXOffset" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "TopXOffsetAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcTrimmedCurve" : {
      "domain" : null,
      "superclasses" : [ "IfcBoundedCurve" ],
      "fields" : {
        "BasisCurve" : {
          "type" : "IfcCurve",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "Trim1" : {
          "type" : "IfcTrimmingSelect",
          "reference" : true,
          "many" : true,
          "inverse" : false
        },
        "Trim2" : {
          "type" : "IfcTrimmingSelect",
          "reference" : true,
          "many" : true,
          "inverse" : false
        },
        "SenseAgreement" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "MasterRepresentation" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcTubeBundleType" : {
      "domain" : null,
      "superclasses" : [ "IfcEnergyConversionDeviceType" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcTwoDirectionRepeatFactor" : {
      "domain" : null,
      "superclasses" : [ "IfcOneDirectionRepeatFactor" ],
      "fields" : {
        "SecondRepeatFactor" : {
          "type" : "IfcVector",
          "reference" : true,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcTypeObject" : {
      "domain" : null,
      "superclasses" : [ "IfcObjectDefinition" ],
      "fields" : {
        "ApplicableOccurrence" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "HasPropertySets" : {
          "type" : "IfcPropertySetDefinition",
          "reference" : true,
          "many" : true,
          "inverse" : true
        },
        "ObjectTypeOf" : {
          "type" : "IfcRelDefinesByType",
          "reference" : true,
          "many" : true,
          "inverse" : true
        }
      }
    },
    "IfcTypeProduct" : {
      "domain" : null,
      "superclasses" : [ "IfcTypeObject" ],
      "fields" : {
        "RepresentationMaps" : {
          "type" : "IfcRepresentationMap",
          "reference" : true,
          "many" : true,
          "inverse" : false
        },
        "Tag" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcUShapeProfileDef" : {
      "domain" : null,
      "superclasses" : [ "IfcParameterizedProfileDef" ],
      "fields" : {
        "Depth" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "DepthAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "FlangeWidth" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "FlangeWidthAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "WebThickness" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "WebThicknessAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "FlangeThickness" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "FlangeThicknessAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "FilletRadius" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "FilletRadiusAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "EdgeRadius" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "EdgeRadiusAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "FlangeSlope" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "FlangeSlopeAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "CentreOfGravityInX" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "CentreOfGravityInXAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcUnitAssignment" : {
      "domain" : null,
      "superclasses" : [ ],
      "fields" : {
        "Units" : {
          "type" : "IfcUnit",
          "reference" : true,
          "many" : true,
          "inverse" : false
        }
      }
    },
    "IfcUnitaryEquipmentType" : {
      "domain" : null,
      "superclasses" : [ "IfcEnergyConversionDeviceType" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcValveType" : {
      "domain" : null,
      "superclasses" : [ "IfcFlowControllerType" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcVector" : {
      "domain" : null,
      "superclasses" : [ "IfcGeometricRepresentationItem", "IfcVectorOrDirection" ],
      "fields" : {
        "Orientation" : {
          "type" : "IfcDirection",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "Magnitude" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "MagnitudeAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "Dim" : {
          "type" : "long",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcVertex" : {
      "domain" : null,
      "superclasses" : [ "IfcTopologicalRepresentationItem" ],
      "fields" : { }
    },
    "IfcVertexBasedTextureMap" : {
      "domain" : null,
      "superclasses" : [ ],
      "fields" : {
        "TextureVertices" : {
          "type" : "IfcTextureVertex",
          "reference" : true,
          "many" : true,
          "inverse" : false
        },
        "TexturePoints" : {
          "type" : "IfcCartesianPoint",
          "reference" : true,
          "many" : true,
          "inverse" : false
        }
      }
    },
    "IfcVertexLoop" : {
      "domain" : null,
      "superclasses" : [ "IfcLoop" ],
      "fields" : {
        "LoopVertex" : {
          "type" : "IfcVertex",
          "reference" : true,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcVertexPoint" : {
      "domain" : null,
      "superclasses" : [ "IfcVertex", "IfcPointOrVertexPoint" ],
      "fields" : {
        "VertexGeometry" : {
          "type" : "IfcPoint",
          "reference" : true,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcVibrationIsolatorType" : {
      "domain" : null,
      "superclasses" : [ "IfcDiscreteAccessoryType" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcVirtualElement" : {
      "domain" : null,
      "superclasses" : [ "IfcElement" ],
      "fields" : { }
    },
    "IfcVirtualGridIntersection" : {
      "domain" : null,
      "superclasses" : [ ],
      "fields" : {
        "IntersectingAxes" : {
          "type" : "IfcGridAxis",
          "reference" : true,
          "many" : true,
          "inverse" : true
        },
        "OffsetDistances" : {
          "type" : "double",
          "reference" : false,
          "many" : true,
          "inverse" : false
        },
        "OffsetDistancesAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : true,
          "inverse" : false
        }
      }
    },
    "IfcWall" : {
      "domain" : null,
      "superclasses" : [ "IfcBuildingElement" ],
      "fields" : { }
    },
    "IfcWallStandardCase" : {
      "domain" : null,
      "superclasses" : [ "IfcWall" ],
      "fields" : { }
    },
    "IfcWallType" : {
      "domain" : null,
      "superclasses" : [ "IfcBuildingElementType" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcWasteTerminalType" : {
      "domain" : null,
      "superclasses" : [ "IfcFlowTerminalType" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcWaterProperties" : {
      "domain" : null,
      "superclasses" : [ "IfcMaterialProperties" ],
      "fields" : {
        "IsPotable" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "Hardness" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "HardnessAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "AlkalinityConcentration" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "AlkalinityConcentrationAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "AcidityConcentration" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "AcidityConcentrationAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "ImpuritiesContent" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "ImpuritiesContentAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "PHLevel" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "PHLevelAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "DissolvedSolidsContent" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "DissolvedSolidsContentAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcWindow" : {
      "domain" : null,
      "superclasses" : [ "IfcBuildingElement" ],
      "fields" : {
        "OverallHeight" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "OverallHeightAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "OverallWidth" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "OverallWidthAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcWindowLiningProperties" : {
      "domain" : null,
      "superclasses" : [ "IfcPropertySetDefinition" ],
      "fields" : {
        "LiningDepth" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "LiningDepthAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "LiningThickness" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "LiningThicknessAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "TransomThickness" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "TransomThicknessAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "MullionThickness" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "MullionThicknessAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "FirstTransomOffset" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "FirstTransomOffsetAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "SecondTransomOffset" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "SecondTransomOffsetAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "FirstMullionOffset" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "FirstMullionOffsetAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "SecondMullionOffset" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "SecondMullionOffsetAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "ShapeAspectStyle" : {
          "type" : "IfcShapeAspect",
          "reference" : true,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcWindowPanelProperties" : {
      "domain" : null,
      "superclasses" : [ "IfcPropertySetDefinition" ],
      "fields" : {
        "OperationType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "PanelPosition" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "FrameDepth" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "FrameDepthAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "FrameThickness" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "FrameThicknessAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "ShapeAspectStyle" : {
          "type" : "IfcShapeAspect",
          "reference" : true,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcWindowStyle" : {
      "domain" : null,
      "superclasses" : [ "IfcTypeProduct" ],
      "fields" : {
        "ConstructionType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "OperationType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "ParameterTakesPrecedence" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "Sizeable" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcWorkControl" : {
      "domain" : null,
      "superclasses" : [ "IfcControl" ],
      "fields" : {
        "Identifier" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "CreationDate" : {
          "type" : "IfcDateTimeSelect",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "Creators" : {
          "type" : "IfcPerson",
          "reference" : true,
          "many" : true,
          "inverse" : false
        },
        "Purpose" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "Duration" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "DurationAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "TotalFloat" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "TotalFloatAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "StartTime" : {
          "type" : "IfcDateTimeSelect",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "FinishTime" : {
          "type" : "IfcDateTimeSelect",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "WorkControlType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "UserDefinedControlType" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcWorkPlan" : {
      "domain" : null,
      "superclasses" : [ "IfcWorkControl" ],
      "fields" : { }
    },
    "IfcWorkSchedule" : {
      "domain" : null,
      "superclasses" : [ "IfcWorkControl" ],
      "fields" : { }
    },
    "IfcZShapeProfileDef" : {
      "domain" : null,
      "superclasses" : [ "IfcParameterizedProfileDef" ],
      "fields" : {
        "Depth" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "DepthAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "FlangeWidth" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "FlangeWidthAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "WebThickness" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "WebThicknessAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "FlangeThickness" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "FlangeThicknessAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "FilletRadius" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "FilletRadiusAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "EdgeRadius" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "EdgeRadiusAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcZone" : {
      "domain" : null,
      "superclasses" : [ "IfcGroup" ],
      "fields" : { }
    },
    "IfcAbsorbedDoseMeasure" : {
      "domain" : null,
      "superclasses" : [ "IfcDerivedMeasureValue" ],
      "fields" : {
        "wrappedValue" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "wrappedValueAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcAccelerationMeasure" : {
      "domain" : null,
      "superclasses" : [ "IfcDerivedMeasureValue" ],
      "fields" : {
        "wrappedValue" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "wrappedValueAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcAmountOfSubstanceMeasure" : {
      "domain" : null,
      "superclasses" : [ "IfcMeasureValue" ],
      "fields" : {
        "wrappedValue" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "wrappedValueAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcAngularVelocityMeasure" : {
      "domain" : null,
      "superclasses" : [ "IfcDerivedMeasureValue" ],
      "fields" : {
        "wrappedValue" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "wrappedValueAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcAreaMeasure" : {
      "domain" : null,
      "superclasses" : [ "IfcMeasureValue" ],
      "fields" : {
        "wrappedValue" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "wrappedValueAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcBoolean" : {
      "domain" : null,
      "superclasses" : [ "IfcSimpleValue", "IfcValue" ],
      "fields" : {
        "wrappedValue" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcContextDependentMeasure" : {
      "domain" : null,
      "superclasses" : [ "IfcMeasureValue" ],
      "fields" : {
        "wrappedValue" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "wrappedValueAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcCountMeasure" : {
      "domain" : null,
      "superclasses" : [ "IfcMeasureValue" ],
      "fields" : {
        "wrappedValue" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "wrappedValueAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcCurvatureMeasure" : {
      "domain" : null,
      "superclasses" : [ "IfcDerivedMeasureValue" ],
      "fields" : {
        "wrappedValue" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "wrappedValueAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcDayInMonthNumber" : {
      "domain" : null,
      "superclasses" : [ ],
      "fields" : {
        "wrappedValue" : {
          "type" : "long",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcDaylightSavingHour" : {
      "domain" : null,
      "superclasses" : [ ],
      "fields" : {
        "wrappedValue" : {
          "type" : "long",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcDescriptiveMeasure" : {
      "domain" : null,
      "superclasses" : [ "IfcMeasureValue", "IfcSizeSelect" ],
      "fields" : {
        "wrappedValue" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcDimensionCount" : {
      "domain" : null,
      "superclasses" : [ ],
      "fields" : {
        "wrappedValue" : {
          "type" : "long",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcDoseEquivalentMeasure" : {
      "domain" : null,
      "superclasses" : [ "IfcDerivedMeasureValue" ],
      "fields" : {
        "wrappedValue" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "wrappedValueAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcDynamicViscosityMeasure" : {
      "domain" : null,
      "superclasses" : [ "IfcDerivedMeasureValue" ],
      "fields" : {
        "wrappedValue" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "wrappedValueAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcElectricCapacitanceMeasure" : {
      "domain" : null,
      "superclasses" : [ "IfcDerivedMeasureValue" ],
      "fields" : {
        "wrappedValue" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "wrappedValueAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcElectricChargeMeasure" : {
      "domain" : null,
      "superclasses" : [ "IfcDerivedMeasureValue" ],
      "fields" : {
        "wrappedValue" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "wrappedValueAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcElectricConductanceMeasure" : {
      "domain" : null,
      "superclasses" : [ "IfcDerivedMeasureValue" ],
      "fields" : {
        "wrappedValue" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "wrappedValueAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcElectricCurrentMeasure" : {
      "domain" : null,
      "superclasses" : [ "IfcMeasureValue" ],
      "fields" : {
        "wrappedValue" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "wrappedValueAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcElectricResistanceMeasure" : {
      "domain" : null,
      "superclasses" : [ "IfcDerivedMeasureValue" ],
      "fields" : {
        "wrappedValue" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "wrappedValueAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcElectricVoltageMeasure" : {
      "domain" : null,
      "superclasses" : [ "IfcDerivedMeasureValue" ],
      "fields" : {
        "wrappedValue" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "wrappedValueAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcEnergyMeasure" : {
      "domain" : null,
      "superclasses" : [ "IfcDerivedMeasureValue" ],
      "fields" : {
        "wrappedValue" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "wrappedValueAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcFontStyle" : {
      "domain" : null,
      "superclasses" : [ ],
      "fields" : {
        "wrappedValue" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcFontVariant" : {
      "domain" : null,
      "superclasses" : [ ],
      "fields" : {
        "wrappedValue" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcFontWeight" : {
      "domain" : null,
      "superclasses" : [ ],
      "fields" : {
        "wrappedValue" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcForceMeasure" : {
      "domain" : null,
      "superclasses" : [ "IfcDerivedMeasureValue" ],
      "fields" : {
        "wrappedValue" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "wrappedValueAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcFrequencyMeasure" : {
      "domain" : null,
      "superclasses" : [ "IfcDerivedMeasureValue" ],
      "fields" : {
        "wrappedValue" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "wrappedValueAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcGloballyUniqueId" : {
      "domain" : null,
      "superclasses" : [ ],
      "fields" : {
        "wrappedValue" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcHeatFluxDensityMeasure" : {
      "domain" : null,
      "superclasses" : [ "IfcDerivedMeasureValue" ],
      "fields" : {
        "wrappedValue" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "wrappedValueAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcHeatingValueMeasure" : {
      "domain" : null,
      "superclasses" : [ "IfcDerivedMeasureValue" ],
      "fields" : {
        "wrappedValue" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "wrappedValueAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcHourInDay" : {
      "domain" : null,
      "superclasses" : [ ],
      "fields" : {
        "wrappedValue" : {
          "type" : "long",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcIdentifier" : {
      "domain" : null,
      "superclasses" : [ "IfcSimpleValue" ],
      "fields" : {
        "wrappedValue" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcIlluminanceMeasure" : {
      "domain" : null,
      "superclasses" : [ "IfcDerivedMeasureValue" ],
      "fields" : {
        "wrappedValue" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "wrappedValueAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcInductanceMeasure" : {
      "domain" : null,
      "superclasses" : [ "IfcDerivedMeasureValue" ],
      "fields" : {
        "wrappedValue" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "wrappedValueAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcInteger" : {
      "domain" : null,
      "superclasses" : [ "IfcSimpleValue" ],
      "fields" : {
        "wrappedValue" : {
          "type" : "long",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcIntegerCountRateMeasure" : {
      "domain" : null,
      "superclasses" : [ "IfcDerivedMeasureValue" ],
      "fields" : {
        "wrappedValue" : {
          "type" : "long",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcIonConcentrationMeasure" : {
      "domain" : null,
      "superclasses" : [ "IfcDerivedMeasureValue" ],
      "fields" : {
        "wrappedValue" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "wrappedValueAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcIsothermalMoistureCapacityMeasure" : {
      "domain" : null,
      "superclasses" : [ "IfcDerivedMeasureValue" ],
      "fields" : {
        "wrappedValue" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "wrappedValueAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcKinematicViscosityMeasure" : {
      "domain" : null,
      "superclasses" : [ "IfcDerivedMeasureValue" ],
      "fields" : {
        "wrappedValue" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "wrappedValueAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcLabel" : {
      "domain" : null,
      "superclasses" : [ "IfcConditionCriterionSelect", "IfcSimpleValue" ],
      "fields" : {
        "wrappedValue" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcLengthMeasure" : {
      "domain" : null,
      "superclasses" : [ "IfcMeasureValue", "IfcSizeSelect" ],
      "fields" : {
        "wrappedValue" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "wrappedValueAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcLinearForceMeasure" : {
      "domain" : null,
      "superclasses" : [ "IfcDerivedMeasureValue" ],
      "fields" : {
        "wrappedValue" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "wrappedValueAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcLinearMomentMeasure" : {
      "domain" : null,
      "superclasses" : [ "IfcDerivedMeasureValue" ],
      "fields" : {
        "wrappedValue" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "wrappedValueAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcLinearStiffnessMeasure" : {
      "domain" : null,
      "superclasses" : [ "IfcDerivedMeasureValue" ],
      "fields" : {
        "wrappedValue" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "wrappedValueAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcLinearVelocityMeasure" : {
      "domain" : null,
      "superclasses" : [ "IfcDerivedMeasureValue" ],
      "fields" : {
        "wrappedValue" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "wrappedValueAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcLogical" : {
      "domain" : null,
      "superclasses" : [ "IfcSimpleValue" ],
      "fields" : {
        "wrappedValue" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcLuminousFluxMeasure" : {
      "domain" : null,
      "superclasses" : [ "IfcDerivedMeasureValue" ],
      "fields" : {
        "wrappedValue" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "wrappedValueAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcLuminousIntensityDistributionMeasure" : {
      "domain" : null,
      "superclasses" : [ "IfcDerivedMeasureValue" ],
      "fields" : {
        "wrappedValue" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "wrappedValueAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcLuminousIntensityMeasure" : {
      "domain" : null,
      "superclasses" : [ "IfcMeasureValue" ],
      "fields" : {
        "wrappedValue" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "wrappedValueAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcMagneticFluxDensityMeasure" : {
      "domain" : null,
      "superclasses" : [ "IfcDerivedMeasureValue" ],
      "fields" : {
        "wrappedValue" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "wrappedValueAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcMagneticFluxMeasure" : {
      "domain" : null,
      "superclasses" : [ "IfcDerivedMeasureValue" ],
      "fields" : {
        "wrappedValue" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "wrappedValueAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcMassDensityMeasure" : {
      "domain" : null,
      "superclasses" : [ "IfcDerivedMeasureValue" ],
      "fields" : {
        "wrappedValue" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "wrappedValueAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcMassFlowRateMeasure" : {
      "domain" : null,
      "superclasses" : [ "IfcDerivedMeasureValue" ],
      "fields" : {
        "wrappedValue" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "wrappedValueAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcMassMeasure" : {
      "domain" : null,
      "superclasses" : [ "IfcMeasureValue" ],
      "fields" : {
        "wrappedValue" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "wrappedValueAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcMassPerLengthMeasure" : {
      "domain" : null,
      "superclasses" : [ "IfcDerivedMeasureValue" ],
      "fields" : {
        "wrappedValue" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "wrappedValueAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcMinuteInHour" : {
      "domain" : null,
      "superclasses" : [ ],
      "fields" : {
        "wrappedValue" : {
          "type" : "long",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcModulusOfElasticityMeasure" : {
      "domain" : null,
      "superclasses" : [ "IfcDerivedMeasureValue" ],
      "fields" : {
        "wrappedValue" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "wrappedValueAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcModulusOfLinearSubgradeReactionMeasure" : {
      "domain" : null,
      "superclasses" : [ "IfcDerivedMeasureValue" ],
      "fields" : {
        "wrappedValue" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "wrappedValueAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcModulusOfRotationalSubgradeReactionMeasure" : {
      "domain" : null,
      "superclasses" : [ "IfcDerivedMeasureValue" ],
      "fields" : {
        "wrappedValue" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "wrappedValueAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcModulusOfSubgradeReactionMeasure" : {
      "domain" : null,
      "superclasses" : [ "IfcDerivedMeasureValue" ],
      "fields" : {
        "wrappedValue" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "wrappedValueAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcMoistureDiffusivityMeasure" : {
      "domain" : null,
      "superclasses" : [ "IfcDerivedMeasureValue" ],
      "fields" : {
        "wrappedValue" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "wrappedValueAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcMolecularWeightMeasure" : {
      "domain" : null,
      "superclasses" : [ "IfcDerivedMeasureValue" ],
      "fields" : {
        "wrappedValue" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "wrappedValueAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcMomentOfInertiaMeasure" : {
      "domain" : null,
      "superclasses" : [ "IfcDerivedMeasureValue" ],
      "fields" : {
        "wrappedValue" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "wrappedValueAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcMonetaryMeasure" : {
      "domain" : null,
      "superclasses" : [ "IfcAppliedValueSelect", "IfcDerivedMeasureValue" ],
      "fields" : {
        "wrappedValue" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "wrappedValueAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcMonthInYearNumber" : {
      "domain" : null,
      "superclasses" : [ ],
      "fields" : {
        "wrappedValue" : {
          "type" : "long",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcNumericMeasure" : {
      "domain" : null,
      "superclasses" : [ "IfcMeasureValue" ],
      "fields" : {
        "wrappedValue" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "wrappedValueAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcPHMeasure" : {
      "domain" : null,
      "superclasses" : [ "IfcDerivedMeasureValue" ],
      "fields" : {
        "wrappedValue" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "wrappedValueAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcParameterValue" : {
      "domain" : null,
      "superclasses" : [ "IfcMeasureValue", "IfcTrimmingSelect" ],
      "fields" : {
        "wrappedValue" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "wrappedValueAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcPlanarForceMeasure" : {
      "domain" : null,
      "superclasses" : [ "IfcDerivedMeasureValue" ],
      "fields" : {
        "wrappedValue" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "wrappedValueAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcPlaneAngleMeasure" : {
      "domain" : null,
      "superclasses" : [ "IfcMeasureValue", "IfcOrientationSelect" ],
      "fields" : {
        "wrappedValue" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "wrappedValueAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcPowerMeasure" : {
      "domain" : null,
      "superclasses" : [ "IfcDerivedMeasureValue" ],
      "fields" : {
        "wrappedValue" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "wrappedValueAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcPresentableText" : {
      "domain" : null,
      "superclasses" : [ ],
      "fields" : {
        "wrappedValue" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcPressureMeasure" : {
      "domain" : null,
      "superclasses" : [ "IfcDerivedMeasureValue" ],
      "fields" : {
        "wrappedValue" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "wrappedValueAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcRadioActivityMeasure" : {
      "domain" : null,
      "superclasses" : [ "IfcDerivedMeasureValue" ],
      "fields" : {
        "wrappedValue" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "wrappedValueAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcRatioMeasure" : {
      "domain" : null,
      "superclasses" : [ "IfcAppliedValueSelect", "IfcMeasureValue", "IfcSizeSelect" ],
      "fields" : {
        "wrappedValue" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "wrappedValueAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcReal" : {
      "domain" : null,
      "superclasses" : [ "IfcSimpleValue" ],
      "fields" : {
        "wrappedValue" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "wrappedValueAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcRotationalFrequencyMeasure" : {
      "domain" : null,
      "superclasses" : [ "IfcDerivedMeasureValue" ],
      "fields" : {
        "wrappedValue" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "wrappedValueAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcRotationalMassMeasure" : {
      "domain" : null,
      "superclasses" : [ "IfcDerivedMeasureValue" ],
      "fields" : {
        "wrappedValue" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "wrappedValueAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcRotationalStiffnessMeasure" : {
      "domain" : null,
      "superclasses" : [ "IfcDerivedMeasureValue" ],
      "fields" : {
        "wrappedValue" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "wrappedValueAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcSecondInMinute" : {
      "domain" : null,
      "superclasses" : [ ],
      "fields" : {
        "wrappedValue" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "wrappedValueAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcSectionModulusMeasure" : {
      "domain" : null,
      "superclasses" : [ "IfcDerivedMeasureValue" ],
      "fields" : {
        "wrappedValue" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "wrappedValueAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcSectionalAreaIntegralMeasure" : {
      "domain" : null,
      "superclasses" : [ "IfcDerivedMeasureValue" ],
      "fields" : {
        "wrappedValue" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "wrappedValueAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcShearModulusMeasure" : {
      "domain" : null,
      "superclasses" : [ "IfcDerivedMeasureValue" ],
      "fields" : {
        "wrappedValue" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "wrappedValueAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcSolidAngleMeasure" : {
      "domain" : null,
      "superclasses" : [ "IfcMeasureValue" ],
      "fields" : {
        "wrappedValue" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "wrappedValueAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcSoundPowerMeasure" : {
      "domain" : null,
      "superclasses" : [ "IfcDerivedMeasureValue" ],
      "fields" : {
        "wrappedValue" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "wrappedValueAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcSoundPressureMeasure" : {
      "domain" : null,
      "superclasses" : [ "IfcDerivedMeasureValue" ],
      "fields" : {
        "wrappedValue" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "wrappedValueAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcSpecificHeatCapacityMeasure" : {
      "domain" : null,
      "superclasses" : [ "IfcDerivedMeasureValue" ],
      "fields" : {
        "wrappedValue" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "wrappedValueAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcSpecularExponent" : {
      "domain" : null,
      "superclasses" : [ "IfcSpecularHighlightSelect" ],
      "fields" : {
        "wrappedValue" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "wrappedValueAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcSpecularRoughness" : {
      "domain" : null,
      "superclasses" : [ "IfcSpecularHighlightSelect" ],
      "fields" : {
        "wrappedValue" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "wrappedValueAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcTemperatureGradientMeasure" : {
      "domain" : null,
      "superclasses" : [ "IfcDerivedMeasureValue" ],
      "fields" : {
        "wrappedValue" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "wrappedValueAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcText" : {
      "domain" : null,
      "superclasses" : [ "IfcMetricValueSelect", "IfcSimpleValue" ],
      "fields" : {
        "wrappedValue" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcTextAlignment" : {
      "domain" : null,
      "superclasses" : [ ],
      "fields" : {
        "wrappedValue" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcTextDecoration" : {
      "domain" : null,
      "superclasses" : [ ],
      "fields" : {
        "wrappedValue" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcTextFontName" : {
      "domain" : null,
      "superclasses" : [ ],
      "fields" : {
        "wrappedValue" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcTextTransformation" : {
      "domain" : null,
      "superclasses" : [ ],
      "fields" : {
        "wrappedValue" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcThermalAdmittanceMeasure" : {
      "domain" : null,
      "superclasses" : [ "IfcDerivedMeasureValue" ],
      "fields" : {
        "wrappedValue" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "wrappedValueAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcThermalConductivityMeasure" : {
      "domain" : null,
      "superclasses" : [ "IfcDerivedMeasureValue" ],
      "fields" : {
        "wrappedValue" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "wrappedValueAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcThermalExpansionCoefficientMeasure" : {
      "domain" : null,
      "superclasses" : [ "IfcDerivedMeasureValue" ],
      "fields" : {
        "wrappedValue" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "wrappedValueAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcThermalResistanceMeasure" : {
      "domain" : null,
      "superclasses" : [ "IfcDerivedMeasureValue" ],
      "fields" : {
        "wrappedValue" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "wrappedValueAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcThermalTransmittanceMeasure" : {
      "domain" : null,
      "superclasses" : [ "IfcDerivedMeasureValue" ],
      "fields" : {
        "wrappedValue" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "wrappedValueAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcThermodynamicTemperatureMeasure" : {
      "domain" : null,
      "superclasses" : [ "IfcMeasureValue" ],
      "fields" : {
        "wrappedValue" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "wrappedValueAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcTimeMeasure" : {
      "domain" : null,
      "superclasses" : [ "IfcMeasureValue" ],
      "fields" : {
        "wrappedValue" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "wrappedValueAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcTimeStamp" : {
      "domain" : null,
      "superclasses" : [ "IfcDerivedMeasureValue" ],
      "fields" : {
        "wrappedValue" : {
          "type" : "long",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcTorqueMeasure" : {
      "domain" : null,
      "superclasses" : [ "IfcDerivedMeasureValue" ],
      "fields" : {
        "wrappedValue" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "wrappedValueAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcVaporPermeabilityMeasure" : {
      "domain" : null,
      "superclasses" : [ "IfcDerivedMeasureValue" ],
      "fields" : {
        "wrappedValue" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "wrappedValueAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcVolumeMeasure" : {
      "domain" : null,
      "superclasses" : [ "IfcMeasureValue" ],
      "fields" : {
        "wrappedValue" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "wrappedValueAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcVolumetricFlowRateMeasure" : {
      "domain" : null,
      "superclasses" : [ "IfcDerivedMeasureValue" ],
      "fields" : {
        "wrappedValue" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "wrappedValueAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcWarpingConstantMeasure" : {
      "domain" : null,
      "superclasses" : [ "IfcDerivedMeasureValue" ],
      "fields" : {
        "wrappedValue" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "wrappedValueAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcWarpingMomentMeasure" : {
      "domain" : null,
      "superclasses" : [ "IfcDerivedMeasureValue" ],
      "fields" : {
        "wrappedValue" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "wrappedValueAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcYearNumber" : {
      "domain" : null,
      "superclasses" : [ ],
      "fields" : {
        "wrappedValue" : {
          "type" : "long",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcBoxAlignment" : {
      "domain" : null,
      "superclasses" : [ "IfcLabel" ],
      "fields" : { }
    },
    "IfcCompoundPlaneAngleMeasure" : {
      "domain" : null,
      "superclasses" : [ "IfcDerivedMeasureValue" ],
      "fields" : {
        "wrappedValue" : {
          "type" : "long",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcNormalisedRatioMeasure" : {
      "domain" : null,
      "superclasses" : [ "IfcRatioMeasure", "IfcColourOrFactor", "IfcMeasureValue", "IfcSizeSelect" ],
      "fields" : { }
    },
    "IfcPositiveLengthMeasure" : {
      "domain" : null,
      "superclasses" : [ "IfcLengthMeasure", "IfcHatchLineDistanceSelect", "IfcMeasureValue", "IfcSizeSelect" ],
      "fields" : { }
    },
    "IfcPositivePlaneAngleMeasure" : {
      "domain" : null,
      "superclasses" : [ "IfcPlaneAngleMeasure", "IfcMeasureValue" ],
      "fields" : { }
    },
    "IfcPositiveRatioMeasure" : {
      "domain" : null,
      "superclasses" : [ "IfcRatioMeasure", "IfcMeasureValue", "IfcSizeSelect" ],
      "fields" : { }
    },
    "IfcActionSourceTypeEnum" : { },
    "IfcActionTypeEnum" : { },
    "IfcActuatorTypeEnum" : { },
    "IfcAddressTypeEnum" : { },
    "IfcAheadOrBehind" : { },
    "IfcAirTerminalBoxTypeEnum" : { },
    "IfcAirTerminalTypeEnum" : { },
    "IfcAirToAirHeatRecoveryTypeEnum" : { },
    "IfcAlarmTypeEnum" : { },
    "IfcAnalysisModelTypeEnum" : { },
    "IfcAnalysisTheoryTypeEnum" : { },
    "IfcArithmeticOperatorEnum" : { },
    "IfcAssemblyPlaceEnum" : { },
    "IfcBSplineCurveForm" : { },
    "IfcBeamTypeEnum" : { },
    "IfcBenchmarkEnum" : { },
    "IfcBoilerTypeEnum" : { },
    "IfcBooleanOperator" : { },
    "IfcBuildingElementProxyTypeEnum" : { },
    "IfcCableCarrierFittingTypeEnum" : { },
    "IfcCableCarrierSegmentTypeEnum" : { },
    "IfcCableSegmentTypeEnum" : { },
    "IfcChangeActionEnum" : { },
    "IfcChillerTypeEnum" : { },
    "IfcCoilTypeEnum" : { },
    "IfcColumnTypeEnum" : { },
    "IfcCompressorTypeEnum" : { },
    "IfcCondenserTypeEnum" : { },
    "IfcConnectionTypeEnum" : { },
    "IfcConstraintEnum" : { },
    "IfcControllerTypeEnum" : { },
    "IfcCooledBeamTypeEnum" : { },
    "IfcCoolingTowerTypeEnum" : { },
    "IfcCostScheduleTypeEnum" : { },
    "IfcCoveringTypeEnum" : { },
    "IfcCurrencyEnum" : { },
    "IfcCurtainWallTypeEnum" : { },
    "IfcDamperTypeEnum" : { },
    "IfcDataOriginEnum" : { },
    "IfcDerivedUnitEnum" : { },
    "IfcDimensionExtentUsage" : { },
    "IfcDirectionSenseEnum" : { },
    "IfcDistributionChamberElementTypeEnum" : { },
    "IfcDocumentConfidentialityEnum" : { },
    "IfcDocumentStatusEnum" : { },
    "IfcDoorPanelOperationEnum" : { },
    "IfcDoorPanelPositionEnum" : { },
    "IfcDoorStyleConstructionEnum" : { },
    "IfcDoorStyleOperationEnum" : { },
    "IfcDuctFittingTypeEnum" : { },
    "IfcDuctSegmentTypeEnum" : { },
    "IfcDuctSilencerTypeEnum" : { },
    "IfcElectricApplianceTypeEnum" : { },
    "IfcElectricCurrentEnum" : { },
    "IfcElectricDistributionPointFunctionEnum" : { },
    "IfcElectricFlowStorageDeviceTypeEnum" : { },
    "IfcElectricGeneratorTypeEnum" : { },
    "IfcElectricHeaterTypeEnum" : { },
    "IfcElectricMotorTypeEnum" : { },
    "IfcElectricTimeControlTypeEnum" : { },
    "IfcElementAssemblyTypeEnum" : { },
    "IfcElementCompositionEnum" : { },
    "IfcEnergySequenceEnum" : { },
    "IfcEnvironmentalImpactCategoryEnum" : { },
    "IfcEvaporativeCoolerTypeEnum" : { },
    "IfcEvaporatorTypeEnum" : { },
    "IfcFanTypeEnum" : { },
    "IfcFilterTypeEnum" : { },
    "IfcFireSuppressionTerminalTypeEnum" : { },
    "IfcFlowDirectionEnum" : { },
    "IfcFlowInstrumentTypeEnum" : { },
    "IfcFlowMeterTypeEnum" : { },
    "IfcFootingTypeEnum" : { },
    "IfcGasTerminalTypeEnum" : { },
    "IfcGeometricProjectionEnum" : { },
    "IfcGlobalOrLocalEnum" : { },
    "IfcHeatExchangerTypeEnum" : { },
    "IfcHumidifierTypeEnum" : { },
    "IfcInternalOrExternalEnum" : { },
    "IfcInventoryTypeEnum" : { },
    "IfcJunctionBoxTypeEnum" : { },
    "IfcLampTypeEnum" : { },
    "IfcLayerSetDirectionEnum" : { },
    "IfcLightDistributionCurveEnum" : { },
    "IfcLightEmissionSourceEnum" : { },
    "IfcLightFixtureTypeEnum" : { },
    "IfcLoadGroupTypeEnum" : { },
    "IfcLogicalOperatorEnum" : { },
    "IfcMemberTypeEnum" : { },
    "IfcMotorConnectionTypeEnum" : { },
    "IfcNullStyleEnum" : { },
    "IfcObjectTypeEnum" : { },
    "IfcObjectiveEnum" : { },
    "IfcOccupantTypeEnum" : { },
    "IfcOutletTypeEnum" : { },
    "IfcPermeableCoveringOperationEnum" : { },
    "IfcPhysicalOrVirtualEnum" : { },
    "IfcPileConstructionEnum" : { },
    "IfcPileTypeEnum" : { },
    "IfcPipeFittingTypeEnum" : { },
    "IfcPipeSegmentTypeEnum" : { },
    "IfcPlateTypeEnum" : { },
    "IfcProcedureTypeEnum" : { },
    "IfcProfileTypeEnum" : { },
    "IfcProjectOrderRecordTypeEnum" : { },
    "IfcProjectOrderTypeEnum" : { },
    "IfcProjectedOrTrueLengthEnum" : { },
    "IfcPropertySourceEnum" : { },
    "IfcProtectiveDeviceTypeEnum" : { },
    "IfcPumpTypeEnum" : { },
    "IfcRailingTypeEnum" : { },
    "IfcRampFlightTypeEnum" : { },
    "IfcRampTypeEnum" : { },
    "IfcReflectanceMethodEnum" : { },
    "IfcReinforcingBarRoleEnum" : { },
    "IfcReinforcingBarSurfaceEnum" : { },
    "IfcResourceConsumptionEnum" : { },
    "IfcRibPlateDirectionEnum" : { },
    "IfcRoleEnum" : { },
    "IfcRoofTypeEnum" : { },
    "IfcSIPrefix" : { },
    "IfcSIUnitName" : { },
    "IfcSanitaryTerminalTypeEnum" : { },
    "IfcSectionTypeEnum" : { },
    "IfcSensorTypeEnum" : { },
    "IfcSequenceEnum" : { },
    "IfcServiceLifeFactorTypeEnum" : { },
    "IfcServiceLifeTypeEnum" : { },
    "IfcSlabTypeEnum" : { },
    "IfcSoundScaleEnum" : { },
    "IfcSpaceHeaterTypeEnum" : { },
    "IfcSpaceTypeEnum" : { },
    "IfcStackTerminalTypeEnum" : { },
    "IfcStairFlightTypeEnum" : { },
    "IfcStairTypeEnum" : { },
    "IfcStateEnum" : { },
    "IfcStructuralCurveTypeEnum" : { },
    "IfcStructuralSurfaceTypeEnum" : { },
    "IfcSurfaceSide" : { },
    "IfcSurfaceTextureEnum" : { },
    "IfcSwitchingDeviceTypeEnum" : { },
    "IfcTankTypeEnum" : { },
    "IfcTendonTypeEnum" : { },
    "IfcTextPath" : { },
    "IfcThermalLoadSourceEnum" : { },
    "IfcThermalLoadTypeEnum" : { },
    "IfcTimeSeriesDataTypeEnum" : { },
    "IfcTimeSeriesScheduleTypeEnum" : { },
    "IfcTransformerTypeEnum" : { },
    "IfcTransitionCode" : { },
    "IfcTransportElementTypeEnum" : { },
    "IfcTrimmingPreference" : { },
    "IfcTubeBundleTypeEnum" : { },
    "IfcUnitEnum" : { },
    "IfcUnitaryEquipmentTypeEnum" : { },
    "IfcValveTypeEnum" : { },
    "IfcVibrationIsolatorTypeEnum" : { },
    "IfcWallTypeEnum" : { },
    "IfcWasteTerminalTypeEnum" : { },
    "IfcWindowPanelOperationEnum" : { },
    "IfcWindowPanelPositionEnum" : { },
    "IfcWindowStyleConstructionEnum" : { },
    "IfcWindowStyleOperationEnum" : { },
    "IfcWorkControlTypeEnum" : { },
    "IfcComplexNumber" : {
      "domain" : null,
      "superclasses" : [ "IfcMeasureValue" ],
      "fields" : {
        "wrappedValue" : {
          "type" : "double",
          "reference" : false,
          "many" : true,
          "inverse" : false
        },
        "wrappedValueAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : true,
          "inverse" : false
        }
      }
    },
    "IfcNullStyle" : {
      "domain" : null,
      "superclasses" : [ "IfcPresentationStyleSelect" ],
      "fields" : {
        "wrappedValue" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcActorSelect" : {
      "domain" : null,
      "superclasses" : [ ],
      "fields" : { }
    },
    "IfcAppliedValueSelect" : {
      "domain" : null,
      "superclasses" : [ ],
      "fields" : { }
    },
    "IfcAxis2Placement" : {
      "domain" : null,
      "superclasses" : [ ],
      "fields" : { }
    },
    "IfcBooleanOperand" : {
      "domain" : null,
      "superclasses" : [ ],
      "fields" : { }
    },
    "IfcCharacterStyleSelect" : {
      "domain" : null,
      "superclasses" : [ ],
      "fields" : { }
    },
    "IfcClassificationNotationSelect" : {
      "domain" : null,
      "superclasses" : [ ],
      "fields" : { }
    },
    "IfcColour" : {
      "domain" : null,
      "superclasses" : [ "IfcFillStyleSelect", "IfcSymbolStyleSelect" ],
      "fields" : { }
    },
    "IfcColourOrFactor" : {
      "domain" : null,
      "superclasses" : [ ],
      "fields" : { }
    },
    "IfcConditionCriterionSelect" : {
      "domain" : null,
      "superclasses" : [ ],
      "fields" : { }
    },
    "IfcCsgSelect" : {
      "domain" : null,
      "superclasses" : [ ],
      "fields" : { }
    },
    "IfcCurveFontOrScaledCurveFontSelect" : {
      "domain" : null,
      "superclasses" : [ ],
      "fields" : { }
    },
    "IfcCurveOrEdgeCurve" : {
      "domain" : null,
      "superclasses" : [ ],
      "fields" : { }
    },
    "IfcCurveStyleFontSelect" : {
      "domain" : null,
      "superclasses" : [ "IfcCurveFontOrScaledCurveFontSelect" ],
      "fields" : { }
    },
    "IfcDateTimeSelect" : {
      "domain" : null,
      "superclasses" : [ "IfcMetricValueSelect" ],
      "fields" : { }
    },
    "IfcDefinedSymbolSelect" : {
      "domain" : null,
      "superclasses" : [ ],
      "fields" : { }
    },
    "IfcDerivedMeasureValue" : {
      "domain" : null,
      "superclasses" : [ "IfcValue" ],
      "fields" : { }
    },
    "IfcDocumentSelect" : {
      "domain" : null,
      "superclasses" : [ ],
      "fields" : { }
    },
    "IfcDraughtingCalloutElement" : {
      "domain" : null,
      "superclasses" : [ ],
      "fields" : { }
    },
    "IfcFillAreaStyleTileShapeSelect" : {
      "domain" : null,
      "superclasses" : [ ],
      "fields" : { }
    },
    "IfcFillStyleSelect" : {
      "domain" : null,
      "superclasses" : [ ],
      "fields" : { }
    },
    "IfcGeometricSetSelect" : {
      "domain" : null,
      "superclasses" : [ ],
      "fields" : { }
    },
    "IfcHatchLineDistanceSelect" : {
      "domain" : null,
      "superclasses" : [ ],
      "fields" : { }
    },
    "IfcLayeredItem" : {
      "domain" : null,
      "superclasses" : [ ],
      "fields" : { }
    },
    "IfcLibrarySelect" : {
      "domain" : null,
      "superclasses" : [ ],
      "fields" : { }
    },
    "IfcLightDistributionDataSourceSelect" : {
      "domain" : null,
      "superclasses" : [ ],
      "fields" : { }
    },
    "IfcMaterialSelect" : {
      "domain" : null,
      "superclasses" : [ ],
      "fields" : { }
    },
    "IfcMeasureValue" : {
      "domain" : null,
      "superclasses" : [ "IfcValue" ],
      "fields" : { }
    },
    "IfcMetricValueSelect" : {
      "domain" : null,
      "superclasses" : [ ],
      "fields" : { }
    },
    "IfcObjectReferenceSelect" : {
      "domain" : null,
      "superclasses" : [ ],
      "fields" : { }
    },
    "IfcOrientationSelect" : {
      "domain" : null,
      "superclasses" : [ ],
      "fields" : { }
    },
    "IfcPointOrVertexPoint" : {
      "domain" : null,
      "superclasses" : [ ],
      "fields" : { }
    },
    "IfcPresentationStyleSelect" : {
      "domain" : null,
      "superclasses" : [ ],
      "fields" : { }
    },
    "IfcShell" : {
      "domain" : null,
      "superclasses" : [ ],
      "fields" : { }
    },
    "IfcSimpleValue" : {
      "domain" : null,
      "superclasses" : [ "IfcValue" ],
      "fields" : { }
    },
    "IfcSizeSelect" : {
      "domain" : null,
      "superclasses" : [ ],
      "fields" : { }
    },
    "IfcSpecularHighlightSelect" : {
      "domain" : null,
      "superclasses" : [ ],
      "fields" : { }
    },
    "IfcStructuralActivityAssignmentSelect" : {
      "domain" : null,
      "superclasses" : [ ],
      "fields" : { }
    },
    "IfcSurfaceOrFaceSurface" : {
      "domain" : null,
      "superclasses" : [ ],
      "fields" : { }
    },
    "IfcSurfaceStyleElementSelect" : {
      "domain" : null,
      "superclasses" : [ ],
      "fields" : { }
    },
    "IfcSymbolStyleSelect" : {
      "domain" : null,
      "superclasses" : [ ],
      "fields" : { }
    },
    "IfcTextFontSelect" : {
      "domain" : null,
      "superclasses" : [ ],
      "fields" : { }
    },
    "IfcTextStyleSelect" : {
      "domain" : null,
      "superclasses" : [ ],
      "fields" : { }
    },
    "IfcTrimmingSelect" : {
      "domain" : null,
      "superclasses" : [ ],
      "fields" : { }
    },
    "IfcUnit" : {
      "domain" : null,
      "superclasses" : [ ],
      "fields" : { }
    },
    "IfcValue" : {
      "domain" : null,
      "superclasses" : [ ],
      "fields" : { }
    },
    "IfcVectorOrDirection" : {
      "domain" : null,
      "superclasses" : [ ],
      "fields" : { }
    }
  }
}