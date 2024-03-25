{
  "classes" : {
    "Tristate" : { },
    "IfcActionRequest" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcControl" ],
      "fields" : {
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
        },
        "LongDescription" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcActor" : {
      "domain" : "geometry",
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
      "domain" : "geometry",
      "superclasses" : [ "IfcResourceObjectSelect" ],
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
        },
        "HasExternalReference" : {
          "type" : "IfcExternalReferenceRelationship",
          "reference" : true,
          "many" : true,
          "inverse" : true
        }
      }
    },
    "IfcActuator" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcDistributionControlElement" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcActuatorType" : {
      "domain" : "geometry",
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
      "domain" : "geometry",
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
    "IfcAdvancedBrep" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcManifoldSolidBrep" ],
      "fields" : { }
    },
    "IfcAdvancedBrepWithVoids" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcAdvancedBrep" ],
      "fields" : {
        "Voids" : {
          "type" : "IfcClosedShell",
          "reference" : true,
          "many" : true,
          "inverse" : false
        }
      }
    },
    "IfcAdvancedFace" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcFaceSurface" ],
      "fields" : { }
    },
    "IfcAirTerminal" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcFlowTerminal" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcAirTerminalBox" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcFlowController" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcAirTerminalBoxType" : {
      "domain" : "geometry",
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
      "domain" : "geometry",
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
    "IfcAirToAirHeatRecovery" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcEnergyConversionDevice" ],
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
      "domain" : "geometry",
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
    "IfcAlarm" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcDistributionControlElement" ],
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
      "domain" : "geometry",
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
    "IfcAlignment" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcLinearPositioningElement" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcAlignmentCant" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcLinearElement" ],
      "fields" : {
        "RailHeadDistance" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "RailHeadDistanceAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcAlignmentCantSegment" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcAlignmentParameterSegment" ],
      "fields" : {
        "StartDistAlong" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "StartDistAlongAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "HorizontalLength" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "HorizontalLengthAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "StartCantLeft" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "StartCantLeftAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "EndCantLeft" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "EndCantLeftAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "StartCantRight" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "StartCantRightAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "EndCantRight" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "EndCantRightAsString" : {
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
    "IfcAlignmentHorizontal" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcLinearElement" ],
      "fields" : { }
    },
    "IfcAlignmentHorizontalSegment" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcAlignmentParameterSegment" ],
      "fields" : {
        "StartPoint" : {
          "type" : "IfcCartesianPoint",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "StartDirection" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "StartDirectionAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "StartRadiusOfCurvature" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "StartRadiusOfCurvatureAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "EndRadiusOfCurvature" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "EndRadiusOfCurvatureAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "SegmentLength" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "SegmentLengthAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "GravityCenterLineHeight" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "GravityCenterLineHeightAsString" : {
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
    "IfcAlignmentParameterSegment" : {
      "domain" : "geometry",
      "superclasses" : [ ],
      "fields" : {
        "StartTag" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "EndTag" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcAlignmentSegment" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcLinearElement" ],
      "fields" : {
        "DesignParameters" : {
          "type" : "IfcAlignmentParameterSegment",
          "reference" : true,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcAlignmentVertical" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcLinearElement" ],
      "fields" : { }
    },
    "IfcAlignmentVerticalSegment" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcAlignmentParameterSegment" ],
      "fields" : {
        "StartDistAlong" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "StartDistAlongAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "HorizontalLength" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "HorizontalLengthAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "StartHeight" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "StartHeightAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "StartGradient" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "StartGradientAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "EndGradient" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "EndGradientAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "RadiusOfCurvature" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "RadiusOfCurvatureAsString" : {
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
    "IfcAnnotation" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcProduct" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "ContainedInStructure" : {
          "type" : "IfcRelContainedInSpatialStructure",
          "reference" : true,
          "many" : true,
          "inverse" : true
        }
      }
    },
    "IfcAnnotationFillArea" : {
      "domain" : "geometry",
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
    "IfcApplication" : {
      "domain" : "geometry",
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
      "domain" : "geometry",
      "superclasses" : [ "IfcMetricValueSelect", "IfcObjectReferenceSelect", "IfcResourceObjectSelect" ],
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
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "FixedUntilDate" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "Category" : {
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
        },
        "ArithmeticOperator" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "Components" : {
          "type" : "IfcAppliedValue",
          "reference" : true,
          "many" : true,
          "inverse" : false
        },
        "HasExternalReference" : {
          "type" : "IfcExternalReferenceRelationship",
          "reference" : true,
          "many" : true,
          "inverse" : true
        }
      }
    },
    "IfcApproval" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcResourceObjectSelect" ],
      "fields" : {
        "Identifier" : {
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
        "TimeOfApproval" : {
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
        "Level" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "Qualifier" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "RequestingApproval" : {
          "type" : "IfcActorSelect",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "GivingApproval" : {
          "type" : "IfcActorSelect",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "HasExternalReferences" : {
          "type" : "IfcExternalReferenceRelationship",
          "reference" : true,
          "many" : true,
          "inverse" : true
        },
        "ApprovedObjects" : {
          "type" : "IfcRelAssociatesApproval",
          "reference" : true,
          "many" : true,
          "inverse" : true
        },
        "ApprovedResources" : {
          "type" : "IfcResourceApprovalRelationship",
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
    "IfcApprovalRelationship" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcResourceLevelRelationship" ],
      "fields" : {
        "RelatingApproval" : {
          "type" : "IfcApproval",
          "reference" : true,
          "many" : false,
          "inverse" : true
        },
        "RelatedApprovals" : {
          "type" : "IfcApproval",
          "reference" : true,
          "many" : true,
          "inverse" : true
        }
      }
    },
    "IfcArbitraryClosedProfileDef" : {
      "domain" : "geometry",
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
      "domain" : "geometry",
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
      "domain" : "geometry",
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
      "domain" : "geometry",
      "superclasses" : [ "IfcGroup" ],
      "fields" : {
        "Identification" : {
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
          "type" : "string",
          "reference" : false,
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
      "domain" : "geometry",
      "superclasses" : [ "IfcParameterizedProfileDef" ],
      "fields" : {
        "BottomFlangeWidth" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "BottomFlangeWidthAsString" : {
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
        "BottomFlangeThickness" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "BottomFlangeThicknessAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "BottomFlangeFilletRadius" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "BottomFlangeFilletRadiusAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
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
        "BottomFlangeEdgeRadius" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "BottomFlangeEdgeRadiusAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "BottomFlangeSlope" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "BottomFlangeSlopeAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "TopFlangeEdgeRadius" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "TopFlangeEdgeRadiusAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "TopFlangeSlope" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "TopFlangeSlopeAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcAudioVisualAppliance" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcFlowTerminal" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcAudioVisualApplianceType" : {
      "domain" : "geometry",
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
    "IfcAxis1Placement" : {
      "domain" : "geometry",
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
      "domain" : "geometry",
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
      "domain" : "geometry",
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
    "IfcAxis2PlacementLinear" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcPlacement" ],
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
      "domain" : "geometry",
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
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "SelfIntersect" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "UpperIndexOnControlPoints" : {
          "type" : "long",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcBSplineCurveWithKnots" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcBSplineCurve" ],
      "fields" : {
        "KnotMultiplicities" : {
          "type" : "long",
          "reference" : false,
          "many" : true,
          "inverse" : false
        },
        "Knots" : {
          "type" : "double",
          "reference" : false,
          "many" : true,
          "inverse" : false
        },
        "KnotsAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : true,
          "inverse" : false
        },
        "KnotSpec" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "UpperIndexOnKnots" : {
          "type" : "long",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcBSplineSurface" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcBoundedSurface" ],
      "fields" : {
        "UDegree" : {
          "type" : "long",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "VDegree" : {
          "type" : "long",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "ControlPointsList" : {
          "type" : "ListOfIfcCartesianPoint",
          "reference" : true,
          "many" : true,
          "inverse" : false
        },
        "SurfaceForm" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "UClosed" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "VClosed" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "SelfIntersect" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "UUpper" : {
          "type" : "long",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "VUpper" : {
          "type" : "long",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcBSplineSurfaceWithKnots" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcBSplineSurface" ],
      "fields" : {
        "UMultiplicities" : {
          "type" : "long",
          "reference" : false,
          "many" : true,
          "inverse" : false
        },
        "VMultiplicities" : {
          "type" : "long",
          "reference" : false,
          "many" : true,
          "inverse" : false
        },
        "UKnots" : {
          "type" : "double",
          "reference" : false,
          "many" : true,
          "inverse" : false
        },
        "UKnotsAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : true,
          "inverse" : false
        },
        "VKnots" : {
          "type" : "double",
          "reference" : false,
          "many" : true,
          "inverse" : false
        },
        "VKnotsAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : true,
          "inverse" : false
        },
        "KnotSpec" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "KnotVUpper" : {
          "type" : "long",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "KnotUUpper" : {
          "type" : "long",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcBeam" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcBuiltElement" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcBeamType" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcBuiltElementType" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcBearing" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcBuiltElement" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcBearingType" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcBuiltElementType" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcBlobTexture" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcSurfaceTexture" ],
      "fields" : {
        "RasterFormat" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "RasterCode" : {
          "type" : "bytearray",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcBlock" : {
      "domain" : "geometry",
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
    "IfcBoiler" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcEnergyConversionDevice" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcBoilerType" : {
      "domain" : "geometry",
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
      "domain" : "geometry",
      "superclasses" : [ "IfcBooleanResult" ],
      "fields" : { }
    },
    "IfcBooleanResult" : {
      "domain" : "geometry",
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
    "IfcBorehole" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcGeotechnicalAssembly" ],
      "fields" : { }
    },
    "IfcBoundaryCondition" : {
      "domain" : "geometry",
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
    "IfcBoundaryCurve" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcCompositeCurveOnSurface" ],
      "fields" : { }
    },
    "IfcBoundaryEdgeCondition" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcBoundaryCondition" ],
      "fields" : {
        "TranslationalStiffnessByLengthX" : {
          "type" : "IfcModulusOfTranslationalSubgradeReactionSelect",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "TranslationalStiffnessByLengthY" : {
          "type" : "IfcModulusOfTranslationalSubgradeReactionSelect",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "TranslationalStiffnessByLengthZ" : {
          "type" : "IfcModulusOfTranslationalSubgradeReactionSelect",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "RotationalStiffnessByLengthX" : {
          "type" : "IfcModulusOfRotationalSubgradeReactionSelect",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "RotationalStiffnessByLengthY" : {
          "type" : "IfcModulusOfRotationalSubgradeReactionSelect",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "RotationalStiffnessByLengthZ" : {
          "type" : "IfcModulusOfRotationalSubgradeReactionSelect",
          "reference" : true,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcBoundaryFaceCondition" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcBoundaryCondition" ],
      "fields" : {
        "TranslationalStiffnessByAreaX" : {
          "type" : "IfcModulusOfSubgradeReactionSelect",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "TranslationalStiffnessByAreaY" : {
          "type" : "IfcModulusOfSubgradeReactionSelect",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "TranslationalStiffnessByAreaZ" : {
          "type" : "IfcModulusOfSubgradeReactionSelect",
          "reference" : true,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcBoundaryNodeCondition" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcBoundaryCondition" ],
      "fields" : {
        "TranslationalStiffnessX" : {
          "type" : "IfcTranslationalStiffnessSelect",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "TranslationalStiffnessY" : {
          "type" : "IfcTranslationalStiffnessSelect",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "TranslationalStiffnessZ" : {
          "type" : "IfcTranslationalStiffnessSelect",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "RotationalStiffnessX" : {
          "type" : "IfcRotationalStiffnessSelect",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "RotationalStiffnessY" : {
          "type" : "IfcRotationalStiffnessSelect",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "RotationalStiffnessZ" : {
          "type" : "IfcRotationalStiffnessSelect",
          "reference" : true,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcBoundaryNodeConditionWarping" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcBoundaryNodeCondition" ],
      "fields" : {
        "WarpingStiffness" : {
          "type" : "IfcWarpingStiffnessSelect",
          "reference" : true,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcBoundedCurve" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcCurve", "IfcCurveOrEdgeCurve" ],
      "fields" : { }
    },
    "IfcBoundedSurface" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcSurface" ],
      "fields" : { }
    },
    "IfcBoundingBox" : {
      "domain" : "geometry",
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
      "domain" : "geometry",
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
    "IfcBridge" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcFacility" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcBridgePart" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcFacilityPart" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcBuilding" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcFacility" ],
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
    "IfcBuildingElementPart" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcElementComponent" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcBuildingElementPartType" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcElementComponentType" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcBuildingElementProxy" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcBuiltElement" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcBuildingElementProxyType" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcBuiltElementType" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcBuildingStorey" : {
      "domain" : "geometry",
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
    "IfcBuildingSystem" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcSystem" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "LongName" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcBuiltElement" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcElement" ],
      "fields" : { }
    },
    "IfcBuiltElementType" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcElementType" ],
      "fields" : { }
    },
    "IfcBuiltSystem" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcSystem" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "LongName" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcBurner" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcEnergyConversionDevice" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcBurnerType" : {
      "domain" : "geometry",
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
    "IfcCShapeProfileDef" : {
      "domain" : "geometry",
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
        }
      }
    },
    "IfcCableCarrierFitting" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcFlowFitting" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcCableCarrierFittingType" : {
      "domain" : "geometry",
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
    "IfcCableCarrierSegment" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcFlowSegment" ],
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
      "domain" : "geometry",
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
    "IfcCableFitting" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcFlowFitting" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcCableFittingType" : {
      "domain" : "geometry",
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
    "IfcCableSegment" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcFlowSegment" ],
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
      "domain" : "geometry",
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
    "IfcCaissonFoundation" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcDeepFoundation" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcCaissonFoundationType" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcDeepFoundationType" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcCartesianPoint" : {
      "domain" : "geometry",
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
        }
      }
    },
    "IfcCartesianPointList" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcGeometricRepresentationItem" ],
      "fields" : {
        "Dim" : {
          "type" : "long",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcCartesianPointList2D" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcCartesianPointList" ],
      "fields" : {
        "CoordList" : {
          "type" : "ListOfIfcLengthMeasure",
          "reference" : true,
          "many" : true,
          "inverse" : false
        },
        "TagList" : {
          "type" : "string",
          "reference" : false,
          "many" : true,
          "inverse" : false
        }
      }
    },
    "IfcCartesianPointList3D" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcCartesianPointList" ],
      "fields" : {
        "CoordList" : {
          "type" : "ListOfIfcLengthMeasure",
          "reference" : true,
          "many" : true,
          "inverse" : false
        },
        "TagList" : {
          "type" : "string",
          "reference" : false,
          "many" : true,
          "inverse" : false
        }
      }
    },
    "IfcCartesianTransformationOperator" : {
      "domain" : "geometry",
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
        },
        "Scl" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "SclAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcCartesianTransformationOperator2D" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcCartesianTransformationOperator" ],
      "fields" : { }
    },
    "IfcCartesianTransformationOperator2DnonUniform" : {
      "domain" : "geometry",
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
        },
        "Scl2" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "Scl2AsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcCartesianTransformationOperator3D" : {
      "domain" : "geometry",
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
      "domain" : "geometry",
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
        },
        "Scl3" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "Scl3AsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "Scl2" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "Scl2AsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcCenterLineProfileDef" : {
      "domain" : "geometry",
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
    "IfcChiller" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcEnergyConversionDevice" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcChillerType" : {
      "domain" : "geometry",
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
    "IfcChimney" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcBuiltElement" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcChimneyType" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcBuiltElementType" ],
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
      "domain" : "geometry",
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
      "domain" : "geometry",
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
      "domain" : "geometry",
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
    "IfcCivilElement" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcElement" ],
      "fields" : { }
    },
    "IfcCivilElementType" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcElementType" ],
      "fields" : { }
    },
    "IfcClassification" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcExternalInformation", "IfcClassificationReferenceSelect", "IfcClassificationSelect" ],
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
        "Specification" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "ReferenceTokens" : {
          "type" : "string",
          "reference" : false,
          "many" : true,
          "inverse" : false
        },
        "ClassificationForObjects" : {
          "type" : "IfcRelAssociatesClassification",
          "reference" : true,
          "many" : true,
          "inverse" : true
        },
        "HasReferences" : {
          "type" : "IfcClassificationReference",
          "reference" : true,
          "many" : true,
          "inverse" : true
        }
      }
    },
    "IfcClassificationReference" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcExternalReference", "IfcClassificationReferenceSelect", "IfcClassificationSelect" ],
      "fields" : {
        "ReferencedSource" : {
          "type" : "IfcClassificationReferenceSelect",
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
        "Sort" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "ClassificationRefForObjects" : {
          "type" : "IfcRelAssociatesClassification",
          "reference" : true,
          "many" : true,
          "inverse" : true
        },
        "HasReferences" : {
          "type" : "IfcClassificationReference",
          "reference" : true,
          "many" : true,
          "inverse" : true
        }
      }
    },
    "IfcClosedShell" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcConnectedFaceSet", "IfcShell", "IfcSolidOrShell" ],
      "fields" : { }
    },
    "IfcClothoid" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcSpiral" ],
      "fields" : {
        "ClothoidConstant" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "ClothoidConstantAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcCoil" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcEnergyConversionDevice" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcCoilType" : {
      "domain" : "geometry",
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
      "domain" : "geometry",
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
    "IfcColourRgbList" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcPresentationItem" ],
      "fields" : {
        "ColourList" : {
          "type" : "ListOfIfcNormalisedRatioMeasure",
          "reference" : true,
          "many" : true,
          "inverse" : false
        }
      }
    },
    "IfcColourSpecification" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcPresentationItem", "IfcColour" ],
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
      "domain" : "geometry",
      "superclasses" : [ "IfcBuiltElement" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcColumnType" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcBuiltElementType" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcCommunicationsAppliance" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcFlowTerminal" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcCommunicationsApplianceType" : {
      "domain" : "geometry",
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
    "IfcComplexProperty" : {
      "domain" : "geometry",
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
    "IfcComplexPropertyTemplate" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcPropertyTemplate" ],
      "fields" : {
        "UsageName" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "TemplateType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "HasPropertyTemplates" : {
          "type" : "IfcPropertyTemplate",
          "reference" : true,
          "many" : true,
          "inverse" : true
        }
      }
    },
    "IfcCompositeCurve" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcBoundedCurve" ],
      "fields" : {
        "Segments" : {
          "type" : "IfcSegment",
          "reference" : true,
          "many" : true,
          "inverse" : true
        },
        "SelfIntersect" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "ClosedCurve" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "NSegments" : {
          "type" : "long",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcCompositeCurveOnSurface" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcCompositeCurve", "IfcCurveOnSurface" ],
      "fields" : { }
    },
    "IfcCompositeCurveSegment" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcSegment" ],
      "fields" : {
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
        }
      }
    },
    "IfcCompositeProfileDef" : {
      "domain" : "geometry",
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
    "IfcCompressor" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcFlowMovingDevice" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcCompressorType" : {
      "domain" : "geometry",
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
    "IfcCondenser" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcEnergyConversionDevice" ],
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
      "domain" : "geometry",
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
    "IfcConic" : {
      "domain" : "geometry",
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
      "domain" : "geometry",
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
      "domain" : "geometry",
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
      "domain" : "geometry",
      "superclasses" : [ ],
      "fields" : { }
    },
    "IfcConnectionPointEccentricity" : {
      "domain" : "geometry",
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
      "domain" : "geometry",
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
    "IfcConnectionSurfaceGeometry" : {
      "domain" : "geometry",
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
    "IfcConnectionVolumeGeometry" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcConnectionGeometry" ],
      "fields" : {
        "VolumeOnRelatingElement" : {
          "type" : "IfcSolidOrShell",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "VolumeOnRelatedElement" : {
          "type" : "IfcSolidOrShell",
          "reference" : true,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcConstraint" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcResourceObjectSelect" ],
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
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "UserDefinedGrade" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "HasExternalReferences" : {
          "type" : "IfcExternalReferenceRelationship",
          "reference" : true,
          "many" : true,
          "inverse" : true
        },
        "PropertiesForConstraint" : {
          "type" : "IfcResourceConstraintRelationship",
          "reference" : true,
          "many" : true,
          "inverse" : true
        }
      }
    },
    "IfcConstructionEquipmentResource" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcConstructionResource" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcConstructionEquipmentResourceType" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcConstructionResourceType" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcConstructionMaterialResource" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcConstructionResource" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcConstructionMaterialResourceType" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcConstructionResourceType" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcConstructionProductResource" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcConstructionResource" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcConstructionProductResourceType" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcConstructionResourceType" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcConstructionResource" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcResource" ],
      "fields" : {
        "Usage" : {
          "type" : "IfcResourceTime",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "BaseCosts" : {
          "type" : "IfcAppliedValue",
          "reference" : true,
          "many" : true,
          "inverse" : false
        },
        "BaseQuantity" : {
          "type" : "IfcPhysicalQuantity",
          "reference" : true,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcConstructionResourceType" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcTypeResource" ],
      "fields" : {
        "BaseCosts" : {
          "type" : "IfcAppliedValue",
          "reference" : true,
          "many" : true,
          "inverse" : false
        },
        "BaseQuantity" : {
          "type" : "IfcPhysicalQuantity",
          "reference" : true,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcContext" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcObjectDefinition" ],
      "fields" : {
        "ObjectType" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
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
        },
        "IsDefinedBy" : {
          "type" : "IfcRelDefinesByProperties",
          "reference" : true,
          "many" : true,
          "inverse" : true
        },
        "Declares" : {
          "type" : "IfcRelDeclares",
          "reference" : true,
          "many" : true,
          "inverse" : true
        }
      }
    },
    "IfcContextDependentUnit" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcNamedUnit", "IfcResourceObjectSelect" ],
      "fields" : {
        "Name" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "HasExternalReference" : {
          "type" : "IfcExternalReferenceRelationship",
          "reference" : true,
          "many" : true,
          "inverse" : true
        }
      }
    },
    "IfcControl" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcObject" ],
      "fields" : {
        "Identification" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "Controls" : {
          "type" : "IfcRelAssignsToControl",
          "reference" : true,
          "many" : true,
          "inverse" : true
        }
      }
    },
    "IfcController" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcDistributionControlElement" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcControllerType" : {
      "domain" : "geometry",
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
      "domain" : "geometry",
      "superclasses" : [ "IfcNamedUnit", "IfcResourceObjectSelect" ],
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
        },
        "HasExternalReference" : {
          "type" : "IfcExternalReferenceRelationship",
          "reference" : true,
          "many" : true,
          "inverse" : true
        }
      }
    },
    "IfcConversionBasedUnitWithOffset" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcConversionBasedUnit" ],
      "fields" : {
        "ConversionOffset" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "ConversionOffsetAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcConveyorSegment" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcFlowSegment" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcConveyorSegmentType" : {
      "domain" : "geometry",
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
    "IfcCooledBeam" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcEnergyConversionDevice" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcCooledBeamType" : {
      "domain" : "geometry",
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
    "IfcCoolingTower" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcEnergyConversionDevice" ],
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
      "domain" : "geometry",
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
    "IfcCoordinateOperation" : {
      "domain" : "geometry",
      "superclasses" : [ ],
      "fields" : {
        "SourceCRS" : {
          "type" : "IfcCoordinateReferenceSystemSelect",
          "reference" : true,
          "many" : false,
          "inverse" : true
        },
        "TargetCRS" : {
          "type" : "IfcCoordinateReferenceSystem",
          "reference" : true,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcCoordinateReferenceSystem" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcCoordinateReferenceSystemSelect" ],
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
        "GeodeticDatum" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "HasCoordinateOperation" : {
          "type" : "IfcCoordinateOperation",
          "reference" : true,
          "many" : true,
          "inverse" : true
        },
        "WellKnownText" : {
          "type" : "IfcWellKnownText",
          "reference" : true,
          "many" : true,
          "inverse" : true
        }
      }
    },
    "IfcCosineSpiral" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcSpiral" ],
      "fields" : {
        "CosineTerm" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "CosineTermAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "ConstantTerm" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "ConstantTermAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcCostItem" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcControl" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "CostValues" : {
          "type" : "IfcCostValue",
          "reference" : true,
          "many" : true,
          "inverse" : false
        },
        "CostQuantities" : {
          "type" : "IfcPhysicalQuantity",
          "reference" : true,
          "many" : true,
          "inverse" : false
        }
      }
    },
    "IfcCostSchedule" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcControl" ],
      "fields" : {
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
        },
        "SubmittedOn" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "UpdateDate" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcCostValue" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcAppliedValue" ],
      "fields" : { }
    },
    "IfcCourse" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcBuiltElement" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcCourseType" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcBuiltElementType" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcCovering" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcBuiltElement" ],
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
        "CoversElements" : {
          "type" : "IfcRelCoversBldgElements",
          "reference" : true,
          "many" : true,
          "inverse" : true
        }
      }
    },
    "IfcCoveringType" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcBuiltElementType" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcCrewResource" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcConstructionResource" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcCrewResourceType" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcConstructionResourceType" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcCsgPrimitive3D" : {
      "domain" : "geometry",
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
      "domain" : "geometry",
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
      "domain" : "geometry",
      "superclasses" : [ "IfcResourceLevelRelationship" ],
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
          "type" : "string",
          "reference" : false,
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
      "domain" : "geometry",
      "superclasses" : [ "IfcBuiltElement" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcCurtainWallType" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcBuiltElementType" ],
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
      "domain" : "geometry",
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
      "domain" : "geometry",
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
        }
      }
    },
    "IfcCurveBoundedSurface" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcBoundedSurface" ],
      "fields" : {
        "BasisSurface" : {
          "type" : "IfcSurface",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "Boundaries" : {
          "type" : "IfcBoundaryCurve",
          "reference" : true,
          "many" : true,
          "inverse" : false
        },
        "ImplicitOuter" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcCurveSegment" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcSegment" ],
      "fields" : {
        "Placement" : {
          "type" : "IfcPlacement",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "SegmentStart" : {
          "type" : "IfcCurveMeasureSelect",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "SegmentLength" : {
          "type" : "IfcCurveMeasureSelect",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "ParentCurve" : {
          "type" : "IfcCurve",
          "reference" : true,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcCurveStyle" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcPresentationStyle" ],
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
        },
        "ModelOrDraughting" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcCurveStyleFont" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcPresentationItem", "IfcCurveStyleFontSelect" ],
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
      "domain" : "geometry",
      "superclasses" : [ "IfcPresentationItem", "IfcCurveFontOrScaledCurveFontSelect" ],
      "fields" : {
        "Name" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "CurveStyleFont" : {
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
      "domain" : "geometry",
      "superclasses" : [ "IfcPresentationItem" ],
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
    "IfcCylindricalSurface" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcElementarySurface" ],
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
    "IfcDamper" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcFlowController" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcDamperType" : {
      "domain" : "geometry",
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
    "IfcDeepFoundation" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcBuiltElement" ],
      "fields" : { }
    },
    "IfcDeepFoundationType" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcBuiltElementType" ],
      "fields" : { }
    },
    "IfcDerivedProfileDef" : {
      "domain" : "geometry",
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
      "domain" : "geometry",
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
        },
        "Name" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcDerivedUnitElement" : {
      "domain" : "geometry",
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
    "IfcDimensionalExponents" : {
      "domain" : "geometry",
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
      "domain" : "geometry",
      "superclasses" : [ "IfcGeometricRepresentationItem", "IfcGridPlacementDirectionSelect", "IfcVectorOrDirection" ],
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
    "IfcDirectrixCurveSweptAreaSolid" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcSweptAreaSolid" ],
      "fields" : {
        "Directrix" : {
          "type" : "IfcCurve",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "StartParam" : {
          "type" : "IfcCurveMeasureSelect",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "EndParam" : {
          "type" : "IfcCurveMeasureSelect",
          "reference" : true,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcDirectrixDerivedReferenceSweptAreaSolid" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcFixedReferenceSweptAreaSolid" ],
      "fields" : { }
    },
    "IfcDiscreteAccessory" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcElementComponent" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcDiscreteAccessoryType" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcElementComponentType" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcDistributionBoard" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcFlowController" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcDistributionBoardType" : {
      "domain" : "geometry",
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
    "IfcDistributionChamberElement" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcDistributionFlowElement" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcDistributionChamberElementType" : {
      "domain" : "geometry",
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
    "IfcDistributionCircuit" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcDistributionSystem" ],
      "fields" : { }
    },
    "IfcDistributionControlElement" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcDistributionElement" ],
      "fields" : {
        "AssignedToFlowElement" : {
          "type" : "IfcRelFlowControlElements",
          "reference" : true,
          "many" : true,
          "inverse" : true
        }
      }
    },
    "IfcDistributionControlElementType" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcDistributionElementType" ],
      "fields" : { }
    },
    "IfcDistributionElement" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcElement" ],
      "fields" : {
        "HasPorts" : {
          "type" : "IfcRelConnectsPortToElement",
          "reference" : true,
          "many" : true,
          "inverse" : true
        }
      }
    },
    "IfcDistributionElementType" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcElementType" ],
      "fields" : { }
    },
    "IfcDistributionFlowElement" : {
      "domain" : "geometry",
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
      "domain" : "geometry",
      "superclasses" : [ "IfcDistributionElementType" ],
      "fields" : { }
    },
    "IfcDistributionPort" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcPort" ],
      "fields" : {
        "FlowDirection" : {
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
        },
        "SystemType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcDistributionSystem" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcSystem" ],
      "fields" : {
        "LongName" : {
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
    "IfcDocumentInformation" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcExternalInformation", "IfcDocumentSelect" ],
      "fields" : {
        "Identification" : {
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
        "Location" : {
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
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "LastRevisionTime" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "ElectronicFormat" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "ValidFrom" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "ValidUntil" : {
          "type" : "string",
          "reference" : false,
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
        "DocumentInfoForObjects" : {
          "type" : "IfcRelAssociatesDocument",
          "reference" : true,
          "many" : true,
          "inverse" : true
        },
        "HasDocumentReferences" : {
          "type" : "IfcDocumentReference",
          "reference" : true,
          "many" : true,
          "inverse" : true
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
      "domain" : "geometry",
      "superclasses" : [ "IfcResourceLevelRelationship" ],
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
      "domain" : "geometry",
      "superclasses" : [ "IfcExternalReference", "IfcDocumentSelect" ],
      "fields" : {
        "Description" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "ReferencedDocument" : {
          "type" : "IfcDocumentInformation",
          "reference" : true,
          "many" : false,
          "inverse" : true
        },
        "DocumentRefForObjects" : {
          "type" : "IfcRelAssociatesDocument",
          "reference" : true,
          "many" : true,
          "inverse" : true
        }
      }
    },
    "IfcDoor" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcBuiltElement" ],
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
        },
        "PredefinedType" : {
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
        "UserDefinedOperationType" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcDoorLiningProperties" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcPreDefinedPropertySet" ],
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
        },
        "LiningToPanelOffsetX" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "LiningToPanelOffsetXAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "LiningToPanelOffsetY" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "LiningToPanelOffsetYAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcDoorPanelProperties" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcPreDefinedPropertySet" ],
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
    "IfcDoorType" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcBuiltElementType" ],
      "fields" : {
        "PredefinedType" : {
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
        "UserDefinedOperationType" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcDraughtingPreDefinedColour" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcPreDefinedColour" ],
      "fields" : { }
    },
    "IfcDraughtingPreDefinedCurveFont" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcPreDefinedCurveFont" ],
      "fields" : { }
    },
    "IfcDuctFitting" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcFlowFitting" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcDuctFittingType" : {
      "domain" : "geometry",
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
    "IfcDuctSegment" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcFlowSegment" ],
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
      "domain" : "geometry",
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
    "IfcDuctSilencer" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcFlowTreatmentDevice" ],
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
      "domain" : "geometry",
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
    "IfcEarthworksCut" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcFeatureElementSubtraction" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcEarthworksElement" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcBuiltElement" ],
      "fields" : { }
    },
    "IfcEarthworksFill" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcEarthworksElement" ],
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
      "domain" : "geometry",
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
      "domain" : "geometry",
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
    "IfcEdgeLoop" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcLoop" ],
      "fields" : {
        "EdgeList" : {
          "type" : "IfcOrientedEdge",
          "reference" : true,
          "many" : true,
          "inverse" : false
        },
        "Ne" : {
          "type" : "long",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcElectricAppliance" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcFlowTerminal" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcElectricApplianceType" : {
      "domain" : "geometry",
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
    "IfcElectricDistributionBoard" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcFlowController" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcElectricDistributionBoardType" : {
      "domain" : "geometry",
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
    "IfcElectricFlowStorageDevice" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcFlowStorageDevice" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcElectricFlowStorageDeviceType" : {
      "domain" : "geometry",
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
    "IfcElectricFlowTreatmentDevice" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcFlowTreatmentDevice" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcElectricFlowTreatmentDeviceType" : {
      "domain" : "geometry",
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
    "IfcElectricGenerator" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcEnergyConversionDevice" ],
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
      "domain" : "geometry",
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
    "IfcElectricMotor" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcEnergyConversionDevice" ],
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
      "domain" : "geometry",
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
    "IfcElectricTimeControl" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcFlowController" ],
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
      "domain" : "geometry",
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
    "IfcElement" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcProduct", "IfcInterferenceSelect", "IfcStructuralActivityAssignmentSelect" ],
      "fields" : {
        "Tag" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
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
        "IsInterferedByElements" : {
          "type" : "IfcRelInterferesElements",
          "reference" : true,
          "many" : true,
          "inverse" : true
        },
        "InterferesElements" : {
          "type" : "IfcRelInterferesElements",
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
        },
        "HasCoverings" : {
          "type" : "IfcRelCoversBldgElements",
          "reference" : true,
          "many" : true,
          "inverse" : true
        },
        "HasSurfaceFeatures" : {
          "type" : "IfcRelAdheresToElement",
          "reference" : true,
          "many" : true,
          "inverse" : true
        }
      }
    },
    "IfcElementAssembly" : {
      "domain" : "geometry",
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
    "IfcElementAssemblyType" : {
      "domain" : "geometry",
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
    "IfcElementComponent" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcElement" ],
      "fields" : { }
    },
    "IfcElementComponentType" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcElementType" ],
      "fields" : { }
    },
    "IfcElementQuantity" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcQuantitySet" ],
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
      "domain" : "geometry",
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
      "domain" : "geometry",
      "superclasses" : [ "IfcSurface" ],
      "fields" : {
        "Position" : {
          "type" : "IfcAxis2Placement3D",
          "reference" : true,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcEllipse" : {
      "domain" : "geometry",
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
      "domain" : "geometry",
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
      "domain" : "geometry",
      "superclasses" : [ "IfcDistributionFlowElement" ],
      "fields" : { }
    },
    "IfcEnergyConversionDeviceType" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcDistributionFlowElementType" ],
      "fields" : { }
    },
    "IfcEngine" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcEnergyConversionDevice" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcEngineType" : {
      "domain" : "geometry",
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
    "IfcEvaporativeCooler" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcEnergyConversionDevice" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcEvaporativeCoolerType" : {
      "domain" : "geometry",
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
    "IfcEvaporator" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcEnergyConversionDevice" ],
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
      "domain" : "geometry",
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
    "IfcEvent" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcProcess" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "EventTriggerType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "UserDefinedEventTriggerType" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "EventOccurenceTime" : {
          "type" : "IfcEventTime",
          "reference" : true,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcEventTime" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcSchedulingTime" ],
      "fields" : {
        "ActualDate" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "EarlyDate" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "LateDate" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "ScheduleDate" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcEventType" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcTypeProcess" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "EventTriggerType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "UserDefinedEventTriggerType" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcExtendedProperties" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcPropertyAbstraction" ],
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
        "Properties" : {
          "type" : "IfcProperty",
          "reference" : true,
          "many" : true,
          "inverse" : false
        }
      }
    },
    "IfcExternalInformation" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcResourceObjectSelect" ],
      "fields" : { }
    },
    "IfcExternalReference" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcLightDistributionDataSourceSelect", "IfcObjectReferenceSelect", "IfcResourceObjectSelect" ],
      "fields" : {
        "Location" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "Identification" : {
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
        "ExternalReferenceForResources" : {
          "type" : "IfcExternalReferenceRelationship",
          "reference" : true,
          "many" : true,
          "inverse" : true
        }
      }
    },
    "IfcExternalReferenceRelationship" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcResourceLevelRelationship" ],
      "fields" : {
        "RelatingReference" : {
          "type" : "IfcExternalReference",
          "reference" : true,
          "many" : false,
          "inverse" : true
        },
        "RelatedResourceObjects" : {
          "type" : "IfcResourceObjectSelect",
          "reference" : true,
          "many" : true,
          "inverse" : true
        }
      }
    },
    "IfcExternalSpatialElement" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcExternalSpatialStructureElement", "IfcSpaceBoundarySelect" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "BoundedBy" : {
          "type" : "IfcRelSpaceBoundary",
          "reference" : true,
          "many" : true,
          "inverse" : true
        }
      }
    },
    "IfcExternalSpatialStructureElement" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcSpatialElement" ],
      "fields" : { }
    },
    "IfcExternallyDefinedHatchStyle" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcExternalReference", "IfcFillStyleSelect" ],
      "fields" : { }
    },
    "IfcExternallyDefinedSurfaceStyle" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcExternalReference", "IfcSurfaceStyleElementSelect" ],
      "fields" : { }
    },
    "IfcExternallyDefinedTextFont" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcExternalReference", "IfcTextFontSelect" ],
      "fields" : { }
    },
    "IfcExtrudedAreaSolid" : {
      "domain" : "geometry",
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
    "IfcExtrudedAreaSolidTapered" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcExtrudedAreaSolid" ],
      "fields" : {
        "EndSweptArea" : {
          "type" : "IfcProfileDef",
          "reference" : true,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcFace" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcTopologicalRepresentationItem" ],
      "fields" : {
        "Bounds" : {
          "type" : "IfcFaceBound",
          "reference" : true,
          "many" : true,
          "inverse" : false
        },
        "HasTextureMaps" : {
          "type" : "IfcTextureMap",
          "reference" : true,
          "many" : true,
          "inverse" : true
        }
      }
    },
    "IfcFaceBasedSurfaceModel" : {
      "domain" : "geometry",
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
      "domain" : "geometry",
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
      "domain" : "geometry",
      "superclasses" : [ "IfcFaceBound" ],
      "fields" : { }
    },
    "IfcFaceSurface" : {
      "domain" : "geometry",
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
      "domain" : "geometry",
      "superclasses" : [ "IfcManifoldSolidBrep" ],
      "fields" : { }
    },
    "IfcFacetedBrepWithVoids" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcFacetedBrep" ],
      "fields" : {
        "Voids" : {
          "type" : "IfcClosedShell",
          "reference" : true,
          "many" : true,
          "inverse" : false
        }
      }
    },
    "IfcFacility" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcSpatialStructureElement" ],
      "fields" : { }
    },
    "IfcFacilityPart" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcSpatialStructureElement" ],
      "fields" : {
        "UsageType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcFacilityPartCommon" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcFacilityPart" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcFailureConnectionCondition" : {
      "domain" : "geometry",
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
    "IfcFan" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcFlowMovingDevice" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcFanType" : {
      "domain" : "geometry",
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
      "domain" : "geometry",
      "superclasses" : [ "IfcElementComponent" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcFastenerType" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcElementComponentType" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcFeatureElement" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcElement" ],
      "fields" : { }
    },
    "IfcFeatureElementAddition" : {
      "domain" : "geometry",
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
      "domain" : "geometry",
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
      "domain" : "geometry",
      "superclasses" : [ "IfcPresentationStyle" ],
      "fields" : {
        "FillStyles" : {
          "type" : "IfcFillStyleSelect",
          "reference" : true,
          "many" : true,
          "inverse" : false
        },
        "ModelOrDraughting" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcFillAreaStyleHatching" : {
      "domain" : "geometry",
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
    "IfcFillAreaStyleTiles" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcGeometricRepresentationItem", "IfcFillStyleSelect" ],
      "fields" : {
        "TilingPattern" : {
          "type" : "IfcVector",
          "reference" : true,
          "many" : true,
          "inverse" : false
        },
        "Tiles" : {
          "type" : "IfcStyledItem",
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
    "IfcFilter" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcFlowTreatmentDevice" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcFilterType" : {
      "domain" : "geometry",
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
    "IfcFireSuppressionTerminal" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcFlowTerminal" ],
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
      "domain" : "geometry",
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
    "IfcFixedReferenceSweptAreaSolid" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcDirectrixCurveSweptAreaSolid" ],
      "fields" : {
        "FixedReference" : {
          "type" : "IfcDirection",
          "reference" : true,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcFlowController" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcDistributionFlowElement" ],
      "fields" : { }
    },
    "IfcFlowControllerType" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcDistributionFlowElementType" ],
      "fields" : { }
    },
    "IfcFlowFitting" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcDistributionFlowElement" ],
      "fields" : { }
    },
    "IfcFlowFittingType" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcDistributionFlowElementType" ],
      "fields" : { }
    },
    "IfcFlowInstrument" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcDistributionControlElement" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcFlowInstrumentType" : {
      "domain" : "geometry",
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
    "IfcFlowMeter" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcFlowController" ],
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
      "domain" : "geometry",
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
      "domain" : "geometry",
      "superclasses" : [ "IfcDistributionFlowElement" ],
      "fields" : { }
    },
    "IfcFlowMovingDeviceType" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcDistributionFlowElementType" ],
      "fields" : { }
    },
    "IfcFlowSegment" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcDistributionFlowElement" ],
      "fields" : { }
    },
    "IfcFlowSegmentType" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcDistributionFlowElementType" ],
      "fields" : { }
    },
    "IfcFlowStorageDevice" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcDistributionFlowElement" ],
      "fields" : { }
    },
    "IfcFlowStorageDeviceType" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcDistributionFlowElementType" ],
      "fields" : { }
    },
    "IfcFlowTerminal" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcDistributionFlowElement" ],
      "fields" : { }
    },
    "IfcFlowTerminalType" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcDistributionFlowElementType" ],
      "fields" : { }
    },
    "IfcFlowTreatmentDevice" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcDistributionFlowElement" ],
      "fields" : { }
    },
    "IfcFlowTreatmentDeviceType" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcDistributionFlowElementType" ],
      "fields" : { }
    },
    "IfcFooting" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcBuiltElement" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcFootingType" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcBuiltElementType" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcFurnishingElement" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcElement" ],
      "fields" : { }
    },
    "IfcFurnishingElementType" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcElementType" ],
      "fields" : { }
    },
    "IfcFurniture" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcFurnishingElement" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcFurnitureType" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcFurnishingElementType" ],
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
    "IfcGeographicCRS" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcCoordinateReferenceSystem" ],
      "fields" : {
        "PrimeMeridian" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "AngleUnit" : {
          "type" : "IfcNamedUnit",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "HeightUnit" : {
          "type" : "IfcNamedUnit",
          "reference" : true,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcGeographicElement" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcElement" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcGeographicElementType" : {
      "domain" : "geometry",
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
    "IfcGeometricCurveSet" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcGeometricSet" ],
      "fields" : { }
    },
    "IfcGeometricRepresentationContext" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcRepresentationContext", "IfcCoordinateReferenceSystemSelect" ],
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
        },
        "HasCoordinateOperation" : {
          "type" : "IfcCoordinateOperation",
          "reference" : true,
          "many" : true,
          "inverse" : true
        }
      }
    },
    "IfcGeometricRepresentationItem" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcRepresentationItem" ],
      "fields" : { }
    },
    "IfcGeometricRepresentationSubContext" : {
      "domain" : "geometry",
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
      "domain" : "geometry",
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
    "IfcGeomodel" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcGeotechnicalAssembly" ],
      "fields" : { }
    },
    "IfcGeoslice" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcGeotechnicalAssembly" ],
      "fields" : { }
    },
    "IfcGeotechnicalAssembly" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcGeotechnicalElement" ],
      "fields" : { }
    },
    "IfcGeotechnicalElement" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcElement" ],
      "fields" : { }
    },
    "IfcGeotechnicalStratum" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcGeotechnicalElement" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcGradientCurve" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcCompositeCurve" ],
      "fields" : {
        "BaseCurve" : {
          "type" : "IfcBoundedCurve",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "EndPoint" : {
          "type" : "IfcPlacement",
          "reference" : true,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcGrid" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcPositioningElement" ],
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
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcGridAxis" : {
      "domain" : "geometry",
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
      "domain" : "geometry",
      "superclasses" : [ "IfcObjectPlacement" ],
      "fields" : {
        "PlacementLocation" : {
          "type" : "IfcVirtualGridIntersection",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "PlacementRefDirection" : {
          "type" : "IfcGridPlacementDirectionSelect",
          "reference" : true,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcGroup" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcObject", "IfcSpatialReferenceSelect" ],
      "fields" : {
        "IsGroupedBy" : {
          "type" : "IfcRelAssignsToGroup",
          "reference" : true,
          "many" : true,
          "inverse" : true
        },
        "ReferencedInStructures" : {
          "type" : "IfcRelReferencedInSpatialStructure",
          "reference" : true,
          "many" : true,
          "inverse" : true
        }
      }
    },
    "IfcHalfSpaceSolid" : {
      "domain" : "geometry",
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
    "IfcHeatExchanger" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcEnergyConversionDevice" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcHeatExchangerType" : {
      "domain" : "geometry",
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
    "IfcHumidifier" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcEnergyConversionDevice" ],
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
      "domain" : "geometry",
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
    "IfcIShapeProfileDef" : {
      "domain" : "geometry",
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
        }
      }
    },
    "IfcImageTexture" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcSurfaceTexture" ],
      "fields" : {
        "URLReference" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcImpactProtectionDevice" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcElementComponent" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcImpactProtectionDeviceType" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcElementComponentType" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcIndexedColourMap" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcPresentationItem" ],
      "fields" : {
        "MappedTo" : {
          "type" : "IfcTessellatedFaceSet",
          "reference" : true,
          "many" : false,
          "inverse" : true
        },
        "Opacity" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "OpacityAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "Colours" : {
          "type" : "IfcColourRgbList",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "ColourIndex" : {
          "type" : "long",
          "reference" : false,
          "many" : true,
          "inverse" : false
        }
      }
    },
    "IfcIndexedPolyCurve" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcBoundedCurve" ],
      "fields" : {
        "Points" : {
          "type" : "IfcCartesianPointList",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "Segments" : {
          "type" : "IfcSegmentIndexSelect",
          "reference" : true,
          "many" : true,
          "inverse" : false
        },
        "SelfIntersect" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcIndexedPolygonalFace" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcTessellatedItem" ],
      "fields" : {
        "CoordIndex" : {
          "type" : "long",
          "reference" : false,
          "many" : true,
          "inverse" : false
        },
        "ToFaceSet" : {
          "type" : "IfcPolygonalFaceSet",
          "reference" : true,
          "many" : true,
          "inverse" : true
        },
        "HasTexCoords" : {
          "type" : "IfcTextureCoordinateIndices",
          "reference" : true,
          "many" : true,
          "inverse" : true
        }
      }
    },
    "IfcIndexedPolygonalFaceWithVoids" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcIndexedPolygonalFace" ],
      "fields" : {
        "InnerCoordIndices" : {
          "type" : "ListOfELong",
          "reference" : true,
          "many" : true,
          "inverse" : false
        }
      }
    },
    "IfcIndexedPolygonalTextureMap" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcIndexedTextureMap" ],
      "fields" : {
        "TexCoordIndices" : {
          "type" : "IfcTextureCoordinateIndices",
          "reference" : true,
          "many" : true,
          "inverse" : true
        }
      }
    },
    "IfcIndexedTextureMap" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcTextureCoordinate" ],
      "fields" : {
        "MappedTo" : {
          "type" : "IfcTessellatedFaceSet",
          "reference" : true,
          "many" : false,
          "inverse" : true
        },
        "TexCoords" : {
          "type" : "IfcTextureVertexList",
          "reference" : true,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcIndexedTriangleTextureMap" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcIndexedTextureMap" ],
      "fields" : {
        "TexCoordIndex" : {
          "type" : "ListOfELong",
          "reference" : true,
          "many" : true,
          "inverse" : false
        }
      }
    },
    "IfcInterceptor" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcFlowTreatmentDevice" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcInterceptorType" : {
      "domain" : "geometry",
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
    "IfcIntersectionCurve" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcSurfaceCurve" ],
      "fields" : { }
    },
    "IfcInventory" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcGroup" ],
      "fields" : {
        "PredefinedType" : {
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
          "type" : "string",
          "reference" : false,
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
      "domain" : "geometry",
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
      "domain" : "geometry",
      "superclasses" : [ ],
      "fields" : {
        "TimeStamp" : {
          "type" : "string",
          "reference" : false,
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
    "IfcJunctionBox" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcFlowFitting" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcJunctionBoxType" : {
      "domain" : "geometry",
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
    "IfcKerb" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcBuiltElement" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcKerbType" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcBuiltElementType" ],
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
      "domain" : "geometry",
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
        }
      }
    },
    "IfcLaborResource" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcConstructionResource" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcLaborResourceType" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcConstructionResourceType" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcLagTime" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcSchedulingTime" ],
      "fields" : {
        "LagValue" : {
          "type" : "IfcTimeOrRatioSelect",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "DurationType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcLamp" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcFlowTerminal" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcLampType" : {
      "domain" : "geometry",
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
      "domain" : "geometry",
      "superclasses" : [ "IfcExternalInformation", "IfcLibrarySelect" ],
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
          "type" : "IfcActorSelect",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "VersionDate" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "Location" : {
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
        "LibraryInfoForObjects" : {
          "type" : "IfcRelAssociatesLibrary",
          "reference" : true,
          "many" : true,
          "inverse" : true
        },
        "HasLibraryReferences" : {
          "type" : "IfcLibraryReference",
          "reference" : true,
          "many" : true,
          "inverse" : true
        }
      }
    },
    "IfcLibraryReference" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcExternalReference", "IfcLibrarySelect" ],
      "fields" : {
        "Description" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "Language" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "ReferencedLibrary" : {
          "type" : "IfcLibraryInformation",
          "reference" : true,
          "many" : false,
          "inverse" : true
        },
        "LibraryRefForObjects" : {
          "type" : "IfcRelAssociatesLibrary",
          "reference" : true,
          "many" : true,
          "inverse" : true
        }
      }
    },
    "IfcLightDistributionData" : {
      "domain" : "geometry",
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
    "IfcLightFixture" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcFlowTerminal" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcLightFixtureType" : {
      "domain" : "geometry",
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
      "domain" : "geometry",
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
      "domain" : "geometry",
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
      "domain" : "geometry",
      "superclasses" : [ "IfcLightSource" ],
      "fields" : { }
    },
    "IfcLightSourceDirectional" : {
      "domain" : "geometry",
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
      "domain" : "geometry",
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
      "domain" : "geometry",
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
      "domain" : "geometry",
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
      "domain" : "geometry",
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
    "IfcLinearElement" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcProduct" ],
      "fields" : { }
    },
    "IfcLinearPlacement" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcObjectPlacement" ],
      "fields" : {
        "RelativePlacement" : {
          "type" : "IfcAxis2PlacementLinear",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "CartesianPosition" : {
          "type" : "IfcAxis2Placement3D",
          "reference" : true,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcLinearPositioningElement" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcPositioningElement" ],
      "fields" : { }
    },
    "IfcLiquidTerminal" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcFlowTerminal" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcLiquidTerminalType" : {
      "domain" : "geometry",
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
    "IfcLocalPlacement" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcObjectPlacement" ],
      "fields" : {
        "RelativePlacement" : {
          "type" : "IfcAxis2Placement",
          "reference" : true,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcLoop" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcTopologicalRepresentationItem" ],
      "fields" : { }
    },
    "IfcManifoldSolidBrep" : {
      "domain" : "geometry",
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
    "IfcMapConversion" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcCoordinateOperation" ],
      "fields" : {
        "Eastings" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "EastingsAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "Northings" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "NorthingsAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "OrthogonalHeight" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "OrthogonalHeightAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "XAxisAbscissa" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "XAxisAbscissaAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "XAxisOrdinate" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "XAxisOrdinateAsString" : {
          "type" : "string",
          "reference" : false,
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
        }
      }
    },
    "IfcMapConversionScaled" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcMapConversion" ],
      "fields" : {
        "FactorX" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "FactorXAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "FactorY" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "FactorYAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "FactorZ" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "FactorZAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcMappedItem" : {
      "domain" : "geometry",
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
    "IfcMarineFacility" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcFacility" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcMarinePart" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcFacilityPart" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcMaterial" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcMaterialDefinition" ],
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
        "Category" : {
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
        "IsRelatedWith" : {
          "type" : "IfcMaterialRelationship",
          "reference" : true,
          "many" : true,
          "inverse" : true
        },
        "RelatesTo" : {
          "type" : "IfcMaterialRelationship",
          "reference" : true,
          "many" : true,
          "inverse" : true
        }
      }
    },
    "IfcMaterialClassificationRelationship" : {
      "domain" : "geometry",
      "superclasses" : [ ],
      "fields" : {
        "MaterialClassifications" : {
          "type" : "IfcClassificationSelect",
          "reference" : true,
          "many" : true,
          "inverse" : false
        },
        "ClassifiedMaterial" : {
          "type" : "IfcMaterial",
          "reference" : true,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcMaterialConstituent" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcMaterialDefinition" ],
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
        "Material" : {
          "type" : "IfcMaterial",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "Fraction" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "FractionAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "Category" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "ToMaterialConstituentSet" : {
          "type" : "IfcMaterialConstituentSet",
          "reference" : true,
          "many" : false,
          "inverse" : true
        }
      }
    },
    "IfcMaterialConstituentSet" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcMaterialDefinition" ],
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
        "MaterialConstituents" : {
          "type" : "IfcMaterialConstituent",
          "reference" : true,
          "many" : true,
          "inverse" : true
        }
      }
    },
    "IfcMaterialDefinition" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcMaterialSelect", "IfcObjectReferenceSelect", "IfcResourceObjectSelect" ],
      "fields" : {
        "AssociatedTo" : {
          "type" : "IfcRelAssociatesMaterial",
          "reference" : true,
          "many" : true,
          "inverse" : true
        },
        "HasExternalReferences" : {
          "type" : "IfcExternalReferenceRelationship",
          "reference" : true,
          "many" : true,
          "inverse" : true
        },
        "HasProperties" : {
          "type" : "IfcMaterialProperties",
          "reference" : true,
          "many" : true,
          "inverse" : true
        }
      }
    },
    "IfcMaterialDefinitionRepresentation" : {
      "domain" : "geometry",
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
      "domain" : "geometry",
      "superclasses" : [ "IfcMaterialDefinition" ],
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
        "Category" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "Priority" : {
          "type" : "long",
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
      "domain" : "geometry",
      "superclasses" : [ "IfcMaterialDefinition" ],
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
        "Description" : {
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
      "domain" : "geometry",
      "superclasses" : [ "IfcMaterialUsageDefinition" ],
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
        },
        "ReferenceExtent" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "ReferenceExtentAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcMaterialLayerWithOffsets" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcMaterialLayer" ],
      "fields" : {
        "OffsetDirection" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "OffsetValues" : {
          "type" : "double",
          "reference" : false,
          "many" : true,
          "inverse" : false
        },
        "OffsetValuesAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : true,
          "inverse" : false
        }
      }
    },
    "IfcMaterialList" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcMaterialSelect" ],
      "fields" : {
        "Materials" : {
          "type" : "IfcMaterial",
          "reference" : true,
          "many" : true,
          "inverse" : false
        }
      }
    },
    "IfcMaterialProfile" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcMaterialDefinition" ],
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
        "Material" : {
          "type" : "IfcMaterial",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "Profile" : {
          "type" : "IfcProfileDef",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "Priority" : {
          "type" : "long",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "Category" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "ToMaterialProfileSet" : {
          "type" : "IfcMaterialProfileSet",
          "reference" : true,
          "many" : false,
          "inverse" : true
        }
      }
    },
    "IfcMaterialProfileSet" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcMaterialDefinition" ],
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
        "MaterialProfiles" : {
          "type" : "IfcMaterialProfile",
          "reference" : true,
          "many" : true,
          "inverse" : true
        },
        "CompositeProfile" : {
          "type" : "IfcCompositeProfileDef",
          "reference" : true,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcMaterialProfileSetUsage" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcMaterialUsageDefinition" ],
      "fields" : {
        "ForProfileSet" : {
          "type" : "IfcMaterialProfileSet",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "CardinalPoint" : {
          "type" : "long",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "ReferenceExtent" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "ReferenceExtentAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcMaterialProfileSetUsageTapering" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcMaterialProfileSetUsage" ],
      "fields" : {
        "ForProfileEndSet" : {
          "type" : "IfcMaterialProfileSet",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "CardinalEndPoint" : {
          "type" : "long",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcMaterialProfileWithOffsets" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcMaterialProfile" ],
      "fields" : {
        "OffsetValues" : {
          "type" : "double",
          "reference" : false,
          "many" : true,
          "inverse" : false
        },
        "OffsetValuesAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : true,
          "inverse" : false
        }
      }
    },
    "IfcMaterialProperties" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcExtendedProperties" ],
      "fields" : {
        "Material" : {
          "type" : "IfcMaterialDefinition",
          "reference" : true,
          "many" : false,
          "inverse" : true
        }
      }
    },
    "IfcMaterialRelationship" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcResourceLevelRelationship" ],
      "fields" : {
        "RelatingMaterial" : {
          "type" : "IfcMaterial",
          "reference" : true,
          "many" : false,
          "inverse" : true
        },
        "RelatedMaterials" : {
          "type" : "IfcMaterial",
          "reference" : true,
          "many" : true,
          "inverse" : true
        },
        "MaterialExpression" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcMaterialUsageDefinition" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcMaterialSelect" ],
      "fields" : {
        "AssociatedTo" : {
          "type" : "IfcRelAssociatesMaterial",
          "reference" : true,
          "many" : true,
          "inverse" : true
        }
      }
    },
    "IfcMeasureWithUnit" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcAppliedValueSelect", "IfcMetricValueSelect" ],
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
    "IfcMechanicalFastener" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcElementComponent" ],
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
        },
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcMechanicalFastenerType" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcElementComponentType" ],
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
    "IfcMedicalDevice" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcFlowTerminal" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcMedicalDeviceType" : {
      "domain" : "geometry",
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
    "IfcMember" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcBuiltElement" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcMemberType" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcBuiltElementType" ],
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
      "domain" : "geometry",
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
        },
        "ReferencePath" : {
          "type" : "IfcReference",
          "reference" : true,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcMirroredProfileDef" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcDerivedProfileDef" ],
      "fields" : { }
    },
    "IfcMobileTelecommunicationsAppliance" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcFlowTerminal" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcMobileTelecommunicationsApplianceType" : {
      "domain" : "geometry",
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
    "IfcMonetaryUnit" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcUnit" ],
      "fields" : {
        "Currency" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcMooringDevice" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcBuiltElement" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcMooringDeviceType" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcBuiltElementType" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcMotorConnection" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcEnergyConversionDevice" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcMotorConnectionType" : {
      "domain" : "geometry",
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
    "IfcNamedUnit" : {
      "domain" : "geometry",
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
    "IfcNavigationElement" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcBuiltElement" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcNavigationElementType" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcBuiltElementType" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcObject" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcObjectDefinition" ],
      "fields" : {
        "ObjectType" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "IsDeclaredBy" : {
          "type" : "IfcRelDefinesByObject",
          "reference" : true,
          "many" : true,
          "inverse" : true
        },
        "Declares" : {
          "type" : "IfcRelDefinesByObject",
          "reference" : true,
          "many" : true,
          "inverse" : true
        },
        "IsTypedBy" : {
          "type" : "IfcRelDefinesByType",
          "reference" : true,
          "many" : true,
          "inverse" : true
        },
        "IsDefinedBy" : {
          "type" : "IfcRelDefinesByProperties",
          "reference" : true,
          "many" : true,
          "inverse" : true
        }
      }
    },
    "IfcObjectDefinition" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcRoot", "IfcDefinitionSelect" ],
      "fields" : {
        "HasAssignments" : {
          "type" : "IfcRelAssigns",
          "reference" : true,
          "many" : true,
          "inverse" : true
        },
        "Nests" : {
          "type" : "IfcRelNests",
          "reference" : true,
          "many" : true,
          "inverse" : true
        },
        "IsNestedBy" : {
          "type" : "IfcRelNests",
          "reference" : true,
          "many" : true,
          "inverse" : true
        },
        "HasContext" : {
          "type" : "IfcRelDeclares",
          "reference" : true,
          "many" : true,
          "inverse" : true
        },
        "IsDecomposedBy" : {
          "type" : "IfcRelAggregates",
          "reference" : true,
          "many" : true,
          "inverse" : true
        },
        "Decomposes" : {
          "type" : "IfcRelAggregates",
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
      "domain" : "geometry",
      "superclasses" : [ ],
      "fields" : {
        "PlacementRelTo" : {
          "type" : "IfcObjectPlacement",
          "reference" : true,
          "many" : false,
          "inverse" : true
        },
        "PlacesObject" : {
          "type" : "IfcProduct",
          "reference" : true,
          "many" : true,
          "inverse" : true
        },
        "ReferencedByPlacements" : {
          "type" : "IfcObjectPlacement",
          "reference" : true,
          "many" : true,
          "inverse" : true
        }
      }
    },
    "IfcObjective" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcConstraint" ],
      "fields" : {
        "BenchmarkValues" : {
          "type" : "IfcConstraint",
          "reference" : true,
          "many" : true,
          "inverse" : false
        },
        "LogicalAggregator" : {
          "type" : "enum",
          "reference" : false,
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
      "domain" : "geometry",
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
    "IfcOffsetCurve" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcCurve" ],
      "fields" : {
        "BasisCurve" : {
          "type" : "IfcCurve",
          "reference" : true,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcOffsetCurve2D" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcOffsetCurve" ],
      "fields" : {
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
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcOffsetCurve3D" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcOffsetCurve" ],
      "fields" : {
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
          "type" : "enum",
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
    "IfcOffsetCurveByDistances" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcOffsetCurve" ],
      "fields" : {
        "OffsetValues" : {
          "type" : "IfcPointByDistanceExpression",
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
    "IfcOpenCrossProfileDef" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcProfileDef" ],
      "fields" : {
        "HorizontalWidths" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "Widths" : {
          "type" : "double",
          "reference" : false,
          "many" : true,
          "inverse" : false
        },
        "WidthsAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : true,
          "inverse" : false
        },
        "Slopes" : {
          "type" : "double",
          "reference" : false,
          "many" : true,
          "inverse" : false
        },
        "SlopesAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : true,
          "inverse" : false
        },
        "Tags" : {
          "type" : "string",
          "reference" : false,
          "many" : true,
          "inverse" : false
        },
        "OffsetPoint" : {
          "type" : "IfcCartesianPoint",
          "reference" : true,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcOpenShell" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcConnectedFaceSet", "IfcShell" ],
      "fields" : { }
    },
    "IfcOpeningElement" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcFeatureElementSubtraction" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "HasFillings" : {
          "type" : "IfcRelFillsElement",
          "reference" : true,
          "many" : true,
          "inverse" : true
        }
      }
    },
    "IfcOrganization" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcActorSelect", "IfcObjectReferenceSelect", "IfcResourceObjectSelect" ],
      "fields" : {
        "Identification" : {
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
      "domain" : "geometry",
      "superclasses" : [ "IfcResourceLevelRelationship" ],
      "fields" : {
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
      "domain" : "geometry",
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
    "IfcOuterBoundaryCurve" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcBoundaryCurve" ],
      "fields" : { }
    },
    "IfcOutlet" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcFlowTerminal" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcOutletType" : {
      "domain" : "geometry",
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
      "domain" : "geometry",
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
      "domain" : "geometry",
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
      "domain" : "geometry",
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
    "IfcPavement" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcBuiltElement" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcPavementType" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcBuiltElementType" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcPcurve" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcCurve", "IfcCurveOnSurface" ],
      "fields" : {
        "BasisSurface" : {
          "type" : "IfcSurface",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "ReferenceCurve" : {
          "type" : "IfcCurve",
          "reference" : true,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcPerformanceHistory" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcControl" ],
      "fields" : {
        "LifeCyclePhase" : {
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
    "IfcPermeableCoveringProperties" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcPreDefinedPropertySet" ],
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
      "domain" : "geometry",
      "superclasses" : [ "IfcControl" ],
      "fields" : {
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
        },
        "LongDescription" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcPerson" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcActorSelect", "IfcObjectReferenceSelect", "IfcResourceObjectSelect" ],
      "fields" : {
        "Identification" : {
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
      "domain" : "geometry",
      "superclasses" : [ "IfcActorSelect", "IfcObjectReferenceSelect", "IfcResourceObjectSelect" ],
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
      "domain" : "geometry",
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
      "domain" : "geometry",
      "superclasses" : [ "IfcResourceObjectSelect" ],
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
        "HasExternalReferences" : {
          "type" : "IfcExternalReferenceRelationship",
          "reference" : true,
          "many" : true,
          "inverse" : true
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
      "domain" : "geometry",
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
      "domain" : "geometry",
      "superclasses" : [ "IfcDeepFoundation" ],
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
    "IfcPileType" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcDeepFoundationType" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcPipeFitting" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcFlowFitting" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcPipeFittingType" : {
      "domain" : "geometry",
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
    "IfcPipeSegment" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcFlowSegment" ],
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
      "domain" : "geometry",
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
      "domain" : "geometry",
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
      "domain" : "geometry",
      "superclasses" : [ "IfcGeometricRepresentationItem" ],
      "fields" : {
        "Location" : {
          "type" : "IfcPoint",
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
      "domain" : "geometry",
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
      "domain" : "geometry",
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
      "domain" : "geometry",
      "superclasses" : [ "IfcElementarySurface" ],
      "fields" : { }
    },
    "IfcPlate" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcBuiltElement" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcPlateType" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcBuiltElementType" ],
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
      "domain" : "geometry",
      "superclasses" : [ "IfcGeometricRepresentationItem", "IfcGeometricSetSelect", "IfcPointOrVertexPoint" ],
      "fields" : {
        "Dim" : {
          "type" : "long",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcPointByDistanceExpression" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcPoint" ],
      "fields" : {
        "DistanceAlong" : {
          "type" : "IfcCurveMeasureSelect",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "OffsetLateral" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "OffsetLateralAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "OffsetVertical" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "OffsetVerticalAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "OffsetLongitudinal" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "OffsetLongitudinalAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "BasisCurve" : {
          "type" : "IfcCurve",
          "reference" : true,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcPointOnCurve" : {
      "domain" : "geometry",
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
        }
      }
    },
    "IfcPointOnSurface" : {
      "domain" : "geometry",
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
        }
      }
    },
    "IfcPolyLoop" : {
      "domain" : "geometry",
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
      "domain" : "geometry",
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
    "IfcPolygonalFaceSet" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcTessellatedFaceSet" ],
      "fields" : {
        "Closed" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "Faces" : {
          "type" : "IfcIndexedPolygonalFace",
          "reference" : true,
          "many" : true,
          "inverse" : true
        },
        "PnIndex" : {
          "type" : "long",
          "reference" : false,
          "many" : true,
          "inverse" : false
        }
      }
    },
    "IfcPolyline" : {
      "domain" : "geometry",
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
    "IfcPolynomialCurve" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcCurve" ],
      "fields" : {
        "Position" : {
          "type" : "IfcPlacement",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "CoefficientsX" : {
          "type" : "double",
          "reference" : false,
          "many" : true,
          "inverse" : false
        },
        "CoefficientsXAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : true,
          "inverse" : false
        },
        "CoefficientsY" : {
          "type" : "double",
          "reference" : false,
          "many" : true,
          "inverse" : false
        },
        "CoefficientsYAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : true,
          "inverse" : false
        },
        "CoefficientsZ" : {
          "type" : "double",
          "reference" : false,
          "many" : true,
          "inverse" : false
        },
        "CoefficientsZAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : true,
          "inverse" : false
        }
      }
    },
    "IfcPort" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcProduct" ],
      "fields" : {
        "ContainedIn" : {
          "type" : "IfcRelConnectsPortToElement",
          "reference" : true,
          "many" : true,
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
    "IfcPositioningElement" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcProduct" ],
      "fields" : {
        "ContainedInStructure" : {
          "type" : "IfcRelContainedInSpatialStructure",
          "reference" : true,
          "many" : true,
          "inverse" : true
        },
        "Positions" : {
          "type" : "IfcRelPositions",
          "reference" : true,
          "many" : true,
          "inverse" : true
        }
      }
    },
    "IfcPostalAddress" : {
      "domain" : "geometry",
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
      "domain" : "geometry",
      "superclasses" : [ "IfcPreDefinedItem", "IfcColour" ],
      "fields" : { }
    },
    "IfcPreDefinedCurveFont" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcPreDefinedItem", "IfcCurveStyleFontSelect" ],
      "fields" : { }
    },
    "IfcPreDefinedItem" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcPresentationItem" ],
      "fields" : {
        "Name" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcPreDefinedProperties" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcPropertyAbstraction" ],
      "fields" : { }
    },
    "IfcPreDefinedPropertySet" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcPropertySetDefinition" ],
      "fields" : { }
    },
    "IfcPreDefinedTextFont" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcPreDefinedItem", "IfcTextFontSelect" ],
      "fields" : { }
    },
    "IfcPresentationItem" : {
      "domain" : "geometry",
      "superclasses" : [ ],
      "fields" : { }
    },
    "IfcPresentationLayerAssignment" : {
      "domain" : "geometry",
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
      "domain" : "geometry",
      "superclasses" : [ "IfcPresentationLayerAssignment" ],
      "fields" : {
        "LayerOn" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "LayerFrozen" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "LayerBlocked" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "LayerStyles" : {
          "type" : "IfcPresentationStyle",
          "reference" : true,
          "many" : true,
          "inverse" : false
        }
      }
    },
    "IfcPresentationStyle" : {
      "domain" : "geometry",
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
    "IfcProcedure" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcProcess" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcProcedureType" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcTypeProcess" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcProcess" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcObject", "IfcProcessSelect" ],
      "fields" : {
        "Identification" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "LongDescription" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "IsPredecessorTo" : {
          "type" : "IfcRelSequence",
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
        "OperatesOn" : {
          "type" : "IfcRelAssignsToProcess",
          "reference" : true,
          "many" : true,
          "inverse" : true
        }
      }
    },
    "IfcProduct" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcObject", "IfcProductSelect", "IfcSpatialReferenceSelect" ],
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
        "PositionedRelativeTo" : {
          "type" : "IfcRelPositions",
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
        "geometry" : {
          "type" : "GeometryInfo",
          "reference" : true,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcProductDefinitionShape" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcProductRepresentation", "IfcProductRepresentationSelect" ],
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
      "domain" : "geometry",
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
    "IfcProfileDef" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcResourceObjectSelect" ],
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
        },
        "HasExternalReference" : {
          "type" : "IfcExternalReferenceRelationship",
          "reference" : true,
          "many" : true,
          "inverse" : true
        },
        "HasProperties" : {
          "type" : "IfcProfileProperties",
          "reference" : true,
          "many" : true,
          "inverse" : true
        }
      }
    },
    "IfcProfileProperties" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcExtendedProperties" ],
      "fields" : {
        "ProfileDefinition" : {
          "type" : "IfcProfileDef",
          "reference" : true,
          "many" : false,
          "inverse" : true
        }
      }
    },
    "IfcProject" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcContext" ],
      "fields" : { }
    },
    "IfcProjectLibrary" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcContext" ],
      "fields" : { }
    },
    "IfcProjectOrder" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcControl" ],
      "fields" : {
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
        },
        "LongDescription" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcProjectedCRS" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcCoordinateReferenceSystem" ],
      "fields" : {
        "VerticalDatum" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "MapProjection" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "MapZone" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "MapUnit" : {
          "type" : "IfcNamedUnit",
          "reference" : true,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcProjectionElement" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcFeatureElementAddition" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcProperty" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcPropertyAbstraction" ],
      "fields" : {
        "Name" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "Specification" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "PartOfPset" : {
          "type" : "IfcPropertySet",
          "reference" : true,
          "many" : true,
          "inverse" : true
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
        },
        "HasConstraints" : {
          "type" : "IfcResourceConstraintRelationship",
          "reference" : true,
          "many" : true,
          "inverse" : true
        },
        "HasApprovals" : {
          "type" : "IfcResourceApprovalRelationship",
          "reference" : true,
          "many" : true,
          "inverse" : true
        }
      }
    },
    "IfcPropertyAbstraction" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcResourceObjectSelect" ],
      "fields" : {
        "HasExternalReferences" : {
          "type" : "IfcExternalReferenceRelationship",
          "reference" : true,
          "many" : true,
          "inverse" : true
        }
      }
    },
    "IfcPropertyBoundedValue" : {
      "domain" : "geometry",
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
        },
        "SetPointValue" : {
          "type" : "IfcValue",
          "reference" : true,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcPropertyDefinition" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcRoot", "IfcDefinitionSelect" ],
      "fields" : {
        "HasContext" : {
          "type" : "IfcRelDeclares",
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
    "IfcPropertyDependencyRelationship" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcResourceLevelRelationship" ],
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
        "Expression" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcPropertyEnumeratedValue" : {
      "domain" : "geometry",
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
      "domain" : "geometry",
      "superclasses" : [ "IfcPropertyAbstraction" ],
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
      "domain" : "geometry",
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
      "domain" : "geometry",
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
      "domain" : "geometry",
      "superclasses" : [ "IfcPropertySetDefinition" ],
      "fields" : {
        "HasProperties" : {
          "type" : "IfcProperty",
          "reference" : true,
          "many" : true,
          "inverse" : true
        }
      }
    },
    "IfcPropertySetDefinition" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcPropertyDefinition", "IfcPropertySetDefinitionSelect" ],
      "fields" : {
        "DefinesType" : {
          "type" : "IfcTypeObject",
          "reference" : true,
          "many" : true,
          "inverse" : true
        },
        "IsDefinedBy" : {
          "type" : "IfcRelDefinesByTemplate",
          "reference" : true,
          "many" : true,
          "inverse" : true
        },
        "DefinesOccurrence" : {
          "type" : "IfcRelDefinesByProperties",
          "reference" : true,
          "many" : true,
          "inverse" : true
        }
      }
    },
    "IfcPropertySetTemplate" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcPropertyTemplateDefinition" ],
      "fields" : {
        "TemplateType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "ApplicableEntity" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "HasPropertyTemplates" : {
          "type" : "IfcPropertyTemplate",
          "reference" : true,
          "many" : true,
          "inverse" : true
        },
        "Defines" : {
          "type" : "IfcRelDefinesByTemplate",
          "reference" : true,
          "many" : true,
          "inverse" : true
        }
      }
    },
    "IfcPropertySingleValue" : {
      "domain" : "geometry",
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
      "domain" : "geometry",
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
        },
        "CurveInterpolation" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcPropertyTemplate" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcPropertyTemplateDefinition" ],
      "fields" : {
        "PartOfComplexTemplate" : {
          "type" : "IfcComplexPropertyTemplate",
          "reference" : true,
          "many" : true,
          "inverse" : true
        },
        "PartOfPsetTemplate" : {
          "type" : "IfcPropertySetTemplate",
          "reference" : true,
          "many" : true,
          "inverse" : true
        }
      }
    },
    "IfcPropertyTemplateDefinition" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcPropertyDefinition" ],
      "fields" : { }
    },
    "IfcProtectiveDevice" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcFlowController" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcProtectiveDeviceTrippingUnit" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcDistributionControlElement" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcProtectiveDeviceTrippingUnitType" : {
      "domain" : "geometry",
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
    "IfcProtectiveDeviceType" : {
      "domain" : "geometry",
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
    "IfcPump" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcFlowMovingDevice" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcPumpType" : {
      "domain" : "geometry",
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
      "domain" : "geometry",
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
        },
        "Formula" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcQuantityCount" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcPhysicalSimpleQuantity" ],
      "fields" : {
        "CountValue" : {
          "type" : "long",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "Formula" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcQuantityLength" : {
      "domain" : "geometry",
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
        },
        "Formula" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcQuantityNumber" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcPhysicalSimpleQuantity" ],
      "fields" : {
        "NumberValue" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "NumberValueAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "Formula" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcQuantitySet" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcPropertySetDefinition" ],
      "fields" : { }
    },
    "IfcQuantityTime" : {
      "domain" : "geometry",
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
        },
        "Formula" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcQuantityVolume" : {
      "domain" : "geometry",
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
        },
        "Formula" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcQuantityWeight" : {
      "domain" : "geometry",
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
        },
        "Formula" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcRail" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcBuiltElement" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcRailType" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcBuiltElementType" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcRailing" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcBuiltElement" ],
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
      "domain" : "geometry",
      "superclasses" : [ "IfcBuiltElementType" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcRailway" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcFacility" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcRailwayPart" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcFacilityPart" ],
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
      "domain" : "geometry",
      "superclasses" : [ "IfcBuiltElement" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcRampFlight" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcBuiltElement" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcRampFlightType" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcBuiltElementType" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcRampType" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcBuiltElementType" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcRationalBSplineCurveWithKnots" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcBSplineCurveWithKnots" ],
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
        },
        "Weights" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "WeightsAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcRationalBSplineSurfaceWithKnots" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcBSplineSurfaceWithKnots" ],
      "fields" : {
        "WeightsData" : {
          "type" : "ListOfEDouble",
          "reference" : true,
          "many" : true,
          "inverse" : false
        },
        "Weights" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "WeightsAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcRectangleHollowProfileDef" : {
      "domain" : "geometry",
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
      "domain" : "geometry",
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
      "domain" : "geometry",
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
      "domain" : "geometry",
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
        }
      }
    },
    "IfcRecurrencePattern" : {
      "domain" : "geometry",
      "superclasses" : [ ],
      "fields" : {
        "RecurrenceType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "DayComponent" : {
          "type" : "long",
          "reference" : false,
          "many" : true,
          "inverse" : false
        },
        "WeekdayComponent" : {
          "type" : "long",
          "reference" : false,
          "many" : true,
          "inverse" : false
        },
        "MonthComponent" : {
          "type" : "long",
          "reference" : false,
          "many" : true,
          "inverse" : false
        },
        "Position" : {
          "type" : "long",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "Interval" : {
          "type" : "long",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "Occurrences" : {
          "type" : "long",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "TimePeriods" : {
          "type" : "IfcTimePeriod",
          "reference" : true,
          "many" : true,
          "inverse" : false
        }
      }
    },
    "IfcReference" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcAppliedValueSelect", "IfcMetricValueSelect" ],
      "fields" : {
        "TypeIdentifier" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "AttributeIdentifier" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "InstanceName" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "ListPositions" : {
          "type" : "long",
          "reference" : false,
          "many" : true,
          "inverse" : false
        },
        "InnerReference" : {
          "type" : "IfcReference",
          "reference" : true,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcReferent" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcPositioningElement" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcRegularTimeSeries" : {
      "domain" : "geometry",
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
    "IfcReinforcedSoil" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcEarthworksElement" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcReinforcementBarProperties" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcPreDefinedProperties" ],
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
          "type" : "long",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcReinforcementDefinitionProperties" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcPreDefinedPropertySet" ],
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
      "domain" : "geometry",
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
        "PredefinedType" : {
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
    "IfcReinforcingBarType" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcReinforcingElementType" ],
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
        "BarSurface" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "BendingShapeCode" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "BendingParameters" : {
          "type" : "IfcBendingParameterSelect",
          "reference" : true,
          "many" : true,
          "inverse" : false
        }
      }
    },
    "IfcReinforcingElement" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcElementComponent" ],
      "fields" : {
        "SteelGrade" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcReinforcingElementType" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcElementComponentType" ],
      "fields" : { }
    },
    "IfcReinforcingMesh" : {
      "domain" : "geometry",
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
        },
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcReinforcingMeshType" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcReinforcingElementType" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
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
        },
        "BendingShapeCode" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "BendingParameters" : {
          "type" : "IfcBendingParameterSelect",
          "reference" : true,
          "many" : true,
          "inverse" : false
        }
      }
    },
    "IfcRelAdheresToElement" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcRelDecomposes" ],
      "fields" : {
        "RelatingElement" : {
          "type" : "IfcElement",
          "reference" : true,
          "many" : false,
          "inverse" : true
        },
        "RelatedSurfaceFeatures" : {
          "type" : "IfcSurfaceFeature",
          "reference" : true,
          "many" : true,
          "inverse" : true
        }
      }
    },
    "IfcRelAggregates" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcRelDecomposes" ],
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
    "IfcRelAssigns" : {
      "domain" : "geometry",
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
    "IfcRelAssignsToActor" : {
      "domain" : "geometry",
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
      "domain" : "geometry",
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
      "domain" : "geometry",
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
    "IfcRelAssignsToGroupByFactor" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcRelAssignsToGroup" ],
      "fields" : {
        "Factor" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "FactorAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcRelAssignsToProcess" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcRelAssigns" ],
      "fields" : {
        "RelatingProcess" : {
          "type" : "IfcProcessSelect",
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
      "domain" : "geometry",
      "superclasses" : [ "IfcRelAssigns" ],
      "fields" : {
        "RelatingProduct" : {
          "type" : "IfcProductSelect",
          "reference" : true,
          "many" : false,
          "inverse" : true
        }
      }
    },
    "IfcRelAssignsToResource" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcRelAssigns" ],
      "fields" : {
        "RelatingResource" : {
          "type" : "IfcResourceSelect",
          "reference" : true,
          "many" : false,
          "inverse" : true
        }
      }
    },
    "IfcRelAssociates" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcRelationship" ],
      "fields" : {
        "RelatedObjects" : {
          "type" : "IfcDefinitionSelect",
          "reference" : true,
          "many" : true,
          "inverse" : true
        }
      }
    },
    "IfcRelAssociatesApproval" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcRelAssociates" ],
      "fields" : {
        "RelatingApproval" : {
          "type" : "IfcApproval",
          "reference" : true,
          "many" : false,
          "inverse" : true
        }
      }
    },
    "IfcRelAssociatesClassification" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcRelAssociates" ],
      "fields" : {
        "RelatingClassification" : {
          "type" : "IfcClassificationSelect",
          "reference" : true,
          "many" : false,
          "inverse" : true
        }
      }
    },
    "IfcRelAssociatesConstraint" : {
      "domain" : "geometry",
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
      "domain" : "geometry",
      "superclasses" : [ "IfcRelAssociates" ],
      "fields" : {
        "RelatingDocument" : {
          "type" : "IfcDocumentSelect",
          "reference" : true,
          "many" : false,
          "inverse" : true
        }
      }
    },
    "IfcRelAssociatesLibrary" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcRelAssociates" ],
      "fields" : {
        "RelatingLibrary" : {
          "type" : "IfcLibrarySelect",
          "reference" : true,
          "many" : false,
          "inverse" : true
        }
      }
    },
    "IfcRelAssociatesMaterial" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcRelAssociates" ],
      "fields" : {
        "RelatingMaterial" : {
          "type" : "IfcMaterialSelect",
          "reference" : true,
          "many" : false,
          "inverse" : true
        }
      }
    },
    "IfcRelAssociatesProfileDef" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcRelAssociates" ],
      "fields" : {
        "RelatingProfileDef" : {
          "type" : "IfcProfileDef",
          "reference" : true,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcRelConnects" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcRelationship" ],
      "fields" : { }
    },
    "IfcRelConnectsElements" : {
      "domain" : "geometry",
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
      "domain" : "geometry",
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
      "domain" : "geometry",
      "superclasses" : [ "IfcRelConnects" ],
      "fields" : {
        "RelatingPort" : {
          "type" : "IfcPort",
          "reference" : true,
          "many" : false,
          "inverse" : true
        },
        "RelatedElement" : {
          "type" : "IfcDistributionElement",
          "reference" : true,
          "many" : false,
          "inverse" : true
        }
      }
    },
    "IfcRelConnectsPorts" : {
      "domain" : "geometry",
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
      "domain" : "geometry",
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
    "IfcRelConnectsStructuralMember" : {
      "domain" : "geometry",
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
      "domain" : "geometry",
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
      "domain" : "geometry",
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
      "domain" : "geometry",
      "superclasses" : [ "IfcRelConnects" ],
      "fields" : {
        "RelatedElements" : {
          "type" : "IfcProduct",
          "reference" : true,
          "many" : true,
          "inverse" : true
        },
        "RelatingStructure" : {
          "type" : "IfcSpatialElement",
          "reference" : true,
          "many" : false,
          "inverse" : true
        }
      }
    },
    "IfcRelCoversBldgElements" : {
      "domain" : "geometry",
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
      "domain" : "geometry",
      "superclasses" : [ "IfcRelConnects" ],
      "fields" : {
        "RelatingSpace" : {
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
    "IfcRelDeclares" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcRelationship" ],
      "fields" : {
        "RelatingContext" : {
          "type" : "IfcContext",
          "reference" : true,
          "many" : false,
          "inverse" : true
        },
        "RelatedDefinitions" : {
          "type" : "IfcDefinitionSelect",
          "reference" : true,
          "many" : true,
          "inverse" : true
        }
      }
    },
    "IfcRelDecomposes" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcRelationship" ],
      "fields" : { }
    },
    "IfcRelDefines" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcRelationship" ],
      "fields" : { }
    },
    "IfcRelDefinesByObject" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcRelDefines" ],
      "fields" : {
        "RelatedObjects" : {
          "type" : "IfcObject",
          "reference" : true,
          "many" : true,
          "inverse" : true
        },
        "RelatingObject" : {
          "type" : "IfcObject",
          "reference" : true,
          "many" : false,
          "inverse" : true
        }
      }
    },
    "IfcRelDefinesByProperties" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcRelDefines" ],
      "fields" : {
        "RelatedObjects" : {
          "type" : "IfcObjectDefinition",
          "reference" : true,
          "many" : true,
          "inverse" : true
        },
        "RelatingPropertyDefinition" : {
          "type" : "IfcPropertySetDefinitionSelect",
          "reference" : true,
          "many" : false,
          "inverse" : true
        }
      }
    },
    "IfcRelDefinesByTemplate" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcRelDefines" ],
      "fields" : {
        "RelatedPropertySets" : {
          "type" : "IfcPropertySetDefinition",
          "reference" : true,
          "many" : true,
          "inverse" : true
        },
        "RelatingTemplate" : {
          "type" : "IfcPropertySetTemplate",
          "reference" : true,
          "many" : false,
          "inverse" : true
        }
      }
    },
    "IfcRelDefinesByType" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcRelDefines" ],
      "fields" : {
        "RelatedObjects" : {
          "type" : "IfcObject",
          "reference" : true,
          "many" : true,
          "inverse" : true
        },
        "RelatingType" : {
          "type" : "IfcTypeObject",
          "reference" : true,
          "many" : false,
          "inverse" : true
        }
      }
    },
    "IfcRelFillsElement" : {
      "domain" : "geometry",
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
      "domain" : "geometry",
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
    "IfcRelInterferesElements" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcRelConnects" ],
      "fields" : {
        "RelatingElement" : {
          "type" : "IfcInterferenceSelect",
          "reference" : true,
          "many" : false,
          "inverse" : true
        },
        "RelatedElement" : {
          "type" : "IfcInterferenceSelect",
          "reference" : true,
          "many" : false,
          "inverse" : true
        },
        "InterferenceGeometry" : {
          "type" : "IfcConnectionGeometry",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "InterferenceType" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "ImpliedOrder" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "InterferenceSpace" : {
          "type" : "IfcSpatialZone",
          "reference" : true,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcRelNests" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcRelDecomposes" ],
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
    "IfcRelPositions" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcRelConnects" ],
      "fields" : {
        "RelatingPositioningElement" : {
          "type" : "IfcPositioningElement",
          "reference" : true,
          "many" : false,
          "inverse" : true
        },
        "RelatedProducts" : {
          "type" : "IfcProduct",
          "reference" : true,
          "many" : true,
          "inverse" : true
        }
      }
    },
    "IfcRelProjectsElement" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcRelDecomposes" ],
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
      "domain" : "geometry",
      "superclasses" : [ "IfcRelConnects" ],
      "fields" : {
        "RelatedElements" : {
          "type" : "IfcSpatialReferenceSelect",
          "reference" : true,
          "many" : true,
          "inverse" : true
        },
        "RelatingStructure" : {
          "type" : "IfcSpatialElement",
          "reference" : true,
          "many" : false,
          "inverse" : true
        }
      }
    },
    "IfcRelSequence" : {
      "domain" : "geometry",
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
          "type" : "IfcLagTime",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "SequenceType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "UserDefinedSequenceType" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcRelServicesBuildings" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcRelConnects" ],
      "fields" : {
        "RelatingSystem" : {
          "type" : "IfcSystem",
          "reference" : true,
          "many" : false,
          "inverse" : true
        },
        "RelatedBuildings" : {
          "type" : "IfcSpatialElement",
          "reference" : true,
          "many" : true,
          "inverse" : true
        }
      }
    },
    "IfcRelSpaceBoundary" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcRelConnects" ],
      "fields" : {
        "RelatingSpace" : {
          "type" : "IfcSpaceBoundarySelect",
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
    "IfcRelSpaceBoundary1stLevel" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcRelSpaceBoundary" ],
      "fields" : {
        "ParentBoundary" : {
          "type" : "IfcRelSpaceBoundary1stLevel",
          "reference" : true,
          "many" : false,
          "inverse" : true
        },
        "InnerBoundaries" : {
          "type" : "IfcRelSpaceBoundary1stLevel",
          "reference" : true,
          "many" : true,
          "inverse" : true
        }
      }
    },
    "IfcRelSpaceBoundary2ndLevel" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcRelSpaceBoundary1stLevel" ],
      "fields" : {
        "CorrespondingBoundary" : {
          "type" : "IfcRelSpaceBoundary2ndLevel",
          "reference" : true,
          "many" : false,
          "inverse" : true
        },
        "Corresponds" : {
          "type" : "IfcRelSpaceBoundary2ndLevel",
          "reference" : true,
          "many" : true,
          "inverse" : true
        }
      }
    },
    "IfcRelVoidsElement" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcRelDecomposes" ],
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
      "domain" : "geometry",
      "superclasses" : [ "IfcRoot" ],
      "fields" : { }
    },
    "IfcReparametrisedCompositeCurveSegment" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcCompositeCurveSegment" ],
      "fields" : {
        "ParamLength" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "ParamLengthAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcRepresentation" : {
      "domain" : "geometry",
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
      "domain" : "geometry",
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
      "domain" : "geometry",
      "superclasses" : [ "IfcLayeredItem" ],
      "fields" : {
        "LayerAssignment" : {
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
      "domain" : "geometry",
      "superclasses" : [ "IfcProductRepresentationSelect" ],
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
        "HasShapeAspects" : {
          "type" : "IfcShapeAspect",
          "reference" : true,
          "many" : true,
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
      "domain" : "geometry",
      "superclasses" : [ "IfcObject", "IfcResourceSelect" ],
      "fields" : {
        "Identification" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "LongDescription" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "ResourceOf" : {
          "type" : "IfcRelAssignsToResource",
          "reference" : true,
          "many" : true,
          "inverse" : true
        }
      }
    },
    "IfcResourceApprovalRelationship" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcResourceLevelRelationship" ],
      "fields" : {
        "RelatedResourceObjects" : {
          "type" : "IfcResourceObjectSelect",
          "reference" : true,
          "many" : true,
          "inverse" : true
        },
        "RelatingApproval" : {
          "type" : "IfcApproval",
          "reference" : true,
          "many" : false,
          "inverse" : true
        }
      }
    },
    "IfcResourceConstraintRelationship" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcResourceLevelRelationship" ],
      "fields" : {
        "RelatingConstraint" : {
          "type" : "IfcConstraint",
          "reference" : true,
          "many" : false,
          "inverse" : true
        },
        "RelatedResourceObjects" : {
          "type" : "IfcResourceObjectSelect",
          "reference" : true,
          "many" : true,
          "inverse" : true
        }
      }
    },
    "IfcResourceLevelRelationship" : {
      "domain" : "geometry",
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
        }
      }
    },
    "IfcResourceTime" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcSchedulingTime" ],
      "fields" : {
        "ScheduleWork" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "ScheduleUsage" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "ScheduleUsageAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "ScheduleStart" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "ScheduleFinish" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "ScheduleContour" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "LevelingDelay" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "IsOverAllocated" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "StatusTime" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "ActualWork" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "ActualUsage" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "ActualUsageAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "ActualStart" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "ActualFinish" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "RemainingWork" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "RemainingUsage" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "RemainingUsageAsString" : {
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
        }
      }
    },
    "IfcRevolvedAreaSolid" : {
      "domain" : "geometry",
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
    "IfcRevolvedAreaSolidTapered" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcRevolvedAreaSolid" ],
      "fields" : {
        "EndSweptArea" : {
          "type" : "IfcProfileDef",
          "reference" : true,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcRightCircularCone" : {
      "domain" : "geometry",
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
      "domain" : "geometry",
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
    "IfcRigidOperation" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcCoordinateOperation" ],
      "fields" : {
        "FirstCoordinate" : {
          "type" : "IfcMeasureValue",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "SecondCoordinate" : {
          "type" : "IfcMeasureValue",
          "reference" : true,
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
    "IfcRoad" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcFacility" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcRoadPart" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcFacilityPart" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcRoof" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcBuiltElement" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcRoofType" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcBuiltElementType" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcRoot" : {
      "domain" : "geometry",
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
    "IfcRoundedRectangleProfileDef" : {
      "domain" : "geometry",
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
      "domain" : "geometry",
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
    "IfcSanitaryTerminal" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcFlowTerminal" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcSanitaryTerminalType" : {
      "domain" : "geometry",
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
    "IfcSchedulingTime" : {
      "domain" : "geometry",
      "superclasses" : [ ],
      "fields" : {
        "Name" : {
          "type" : "string",
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
        }
      }
    },
    "IfcSeamCurve" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcSurfaceCurve" ],
      "fields" : { }
    },
    "IfcSecondOrderPolynomialSpiral" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcSpiral" ],
      "fields" : {
        "QuadraticTerm" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "QuadraticTermAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "LinearTerm" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "LinearTermAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "ConstantTerm" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "ConstantTermAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcSectionProperties" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcPreDefinedProperties" ],
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
      "domain" : "geometry",
      "superclasses" : [ "IfcPreDefinedProperties" ],
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
    "IfcSectionedSolid" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcSolidModel" ],
      "fields" : {
        "Directrix" : {
          "type" : "IfcCurve",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "CrossSections" : {
          "type" : "IfcProfileDef",
          "reference" : true,
          "many" : true,
          "inverse" : false
        }
      }
    },
    "IfcSectionedSolidHorizontal" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcSectionedSolid" ],
      "fields" : {
        "CrossSectionPositions" : {
          "type" : "IfcAxis2PlacementLinear",
          "reference" : true,
          "many" : true,
          "inverse" : false
        }
      }
    },
    "IfcSectionedSpine" : {
      "domain" : "geometry",
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
    "IfcSectionedSurface" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcSurface" ],
      "fields" : {
        "Directrix" : {
          "type" : "IfcCurve",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "CrossSectionPositions" : {
          "type" : "IfcAxis2PlacementLinear",
          "reference" : true,
          "many" : true,
          "inverse" : false
        },
        "CrossSections" : {
          "type" : "IfcProfileDef",
          "reference" : true,
          "many" : true,
          "inverse" : false
        }
      }
    },
    "IfcSegment" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcGeometricRepresentationItem" ],
      "fields" : {
        "Transition" : {
          "type" : "enum",
          "reference" : false,
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
    "IfcSegmentedReferenceCurve" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcCompositeCurve" ],
      "fields" : {
        "BaseCurve" : {
          "type" : "IfcBoundedCurve",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "EndPoint" : {
          "type" : "IfcPlacement",
          "reference" : true,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcSensor" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcDistributionControlElement" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcSensorType" : {
      "domain" : "geometry",
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
    "IfcSeventhOrderPolynomialSpiral" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcSpiral" ],
      "fields" : {
        "SepticTerm" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "SepticTermAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "SexticTerm" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "SexticTermAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "QuinticTerm" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "QuinticTermAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "QuarticTerm" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "QuarticTermAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "CubicTerm" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "CubicTermAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "QuadraticTerm" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "QuadraticTermAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "LinearTerm" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "LinearTermAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "ConstantTerm" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "ConstantTermAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcShadingDevice" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcBuiltElement" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcShadingDeviceType" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcBuiltElementType" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcShapeAspect" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcResourceObjectSelect" ],
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
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "PartOfProductDefinitionShape" : {
          "type" : "IfcProductRepresentationSelect",
          "reference" : true,
          "many" : false,
          "inverse" : true
        },
        "HasExternalReferences" : {
          "type" : "IfcExternalReferenceRelationship",
          "reference" : true,
          "many" : true,
          "inverse" : true
        }
      }
    },
    "IfcShapeModel" : {
      "domain" : "geometry",
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
      "domain" : "geometry",
      "superclasses" : [ "IfcShapeModel" ],
      "fields" : { }
    },
    "IfcShellBasedSurfaceModel" : {
      "domain" : "geometry",
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
    "IfcSign" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcElementComponent" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcSignType" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcElementComponentType" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcSignal" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcFlowTerminal" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcSignalType" : {
      "domain" : "geometry",
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
    "IfcSimpleProperty" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcProperty" ],
      "fields" : { }
    },
    "IfcSimplePropertyTemplate" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcPropertyTemplate" ],
      "fields" : {
        "TemplateType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "PrimaryMeasureType" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "SecondaryMeasureType" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "Enumerators" : {
          "type" : "IfcPropertyEnumeration",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "PrimaryUnit" : {
          "type" : "IfcUnit",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "SecondaryUnit" : {
          "type" : "IfcUnit",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "Expression" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "AccessState" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcSineSpiral" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcSpiral" ],
      "fields" : {
        "SineTerm" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "SineTermAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "LinearTerm" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "LinearTermAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "ConstantTerm" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "ConstantTermAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcSite" : {
      "domain" : "geometry",
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
      "domain" : "geometry",
      "superclasses" : [ "IfcBuiltElement" ],
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
      "domain" : "geometry",
      "superclasses" : [ "IfcBuiltElementType" ],
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
      "domain" : "geometry",
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
    "IfcSolarDevice" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcEnergyConversionDevice" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcSolarDeviceType" : {
      "domain" : "geometry",
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
    "IfcSolidModel" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcGeometricRepresentationItem", "IfcBooleanOperand", "IfcSolidOrShell" ],
      "fields" : {
        "Dim" : {
          "type" : "long",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcSpace" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcSpatialStructureElement", "IfcSpaceBoundarySelect" ],
      "fields" : {
        "PredefinedType" : {
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
    "IfcSpaceHeater" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcFlowTerminal" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcSpaceHeaterType" : {
      "domain" : "geometry",
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
    "IfcSpaceType" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcSpatialStructureElementType" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "LongName" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcSpatialElement" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcProduct", "IfcInterferenceSelect" ],
      "fields" : {
        "LongName" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "ContainsElements" : {
          "type" : "IfcRelContainedInSpatialStructure",
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
        "ReferencesElements" : {
          "type" : "IfcRelReferencedInSpatialStructure",
          "reference" : true,
          "many" : true,
          "inverse" : true
        },
        "IsInterferedByElements" : {
          "type" : "IfcRelInterferesElements",
          "reference" : true,
          "many" : true,
          "inverse" : true
        },
        "InterferesElements" : {
          "type" : "IfcRelInterferesElements",
          "reference" : true,
          "many" : true,
          "inverse" : true
        }
      }
    },
    "IfcSpatialElementType" : {
      "domain" : "geometry",
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
    "IfcSpatialStructureElement" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcSpatialElement" ],
      "fields" : {
        "CompositionType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcSpatialStructureElementType" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcSpatialElementType" ],
      "fields" : { }
    },
    "IfcSpatialZone" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcSpatialElement" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcSpatialZoneType" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcSpatialElementType" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "LongName" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcSphere" : {
      "domain" : "geometry",
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
    "IfcSphericalSurface" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcElementarySurface" ],
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
    "IfcSpiral" : {
      "domain" : "geometry",
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
    "IfcStackTerminal" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcFlowTerminal" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcStackTerminalType" : {
      "domain" : "geometry",
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
      "domain" : "geometry",
      "superclasses" : [ "IfcBuiltElement" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcStairFlight" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcBuiltElement" ],
      "fields" : {
        "NumberOfRisers" : {
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
        },
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcStairFlightType" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcBuiltElementType" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcStairType" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcBuiltElementType" ],
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
      "domain" : "geometry",
      "superclasses" : [ "IfcStructuralActivity" ],
      "fields" : {
        "DestabilizingLoad" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcStructuralActivity" : {
      "domain" : "geometry",
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
          "many" : true,
          "inverse" : true
        }
      }
    },
    "IfcStructuralAnalysisModel" : {
      "domain" : "geometry",
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
        },
        "SharedPlacement" : {
          "type" : "IfcObjectPlacement",
          "reference" : true,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcStructuralConnection" : {
      "domain" : "geometry",
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
      "domain" : "geometry",
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
    "IfcStructuralCurveAction" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcStructuralAction" ],
      "fields" : {
        "ProjectedOrTrue" : {
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
    "IfcStructuralCurveConnection" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcStructuralConnection" ],
      "fields" : {
        "AxisDirection" : {
          "type" : "IfcDirection",
          "reference" : true,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcStructuralCurveMember" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcStructuralMember" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "Axis" : {
          "type" : "IfcDirection",
          "reference" : true,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcStructuralCurveMemberVarying" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcStructuralCurveMember" ],
      "fields" : { }
    },
    "IfcStructuralCurveReaction" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcStructuralReaction" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcStructuralItem" : {
      "domain" : "geometry",
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
      "domain" : "geometry",
      "superclasses" : [ "IfcStructuralCurveAction" ],
      "fields" : { }
    },
    "IfcStructuralLoad" : {
      "domain" : "geometry",
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
    "IfcStructuralLoadCase" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcStructuralLoadGroup" ],
      "fields" : {
        "SelfWeightCoefficients" : {
          "type" : "double",
          "reference" : false,
          "many" : true,
          "inverse" : false
        },
        "SelfWeightCoefficientsAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : true,
          "inverse" : false
        }
      }
    },
    "IfcStructuralLoadConfiguration" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcStructuralLoad" ],
      "fields" : {
        "Values" : {
          "type" : "IfcStructuralLoadOrResult",
          "reference" : true,
          "many" : true,
          "inverse" : false
        },
        "Locations" : {
          "type" : "ListOfIfcLengthMeasure",
          "reference" : true,
          "many" : true,
          "inverse" : false
        }
      }
    },
    "IfcStructuralLoadGroup" : {
      "domain" : "geometry",
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
      "domain" : "geometry",
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
    "IfcStructuralLoadOrResult" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcStructuralLoad" ],
      "fields" : { }
    },
    "IfcStructuralLoadPlanarForce" : {
      "domain" : "geometry",
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
      "domain" : "geometry",
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
      "domain" : "geometry",
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
      "domain" : "geometry",
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
      "domain" : "geometry",
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
      "domain" : "geometry",
      "superclasses" : [ "IfcStructuralLoadOrResult" ],
      "fields" : { }
    },
    "IfcStructuralLoadTemperature" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcStructuralLoadStatic" ],
      "fields" : {
        "DeltaTConstant" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "DeltaTConstantAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "DeltaTY" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "DeltaTYAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "DeltaTZ" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "DeltaTZAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcStructuralMember" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcStructuralItem" ],
      "fields" : {
        "ConnectedBy" : {
          "type" : "IfcRelConnectsStructuralMember",
          "reference" : true,
          "many" : true,
          "inverse" : true
        }
      }
    },
    "IfcStructuralPlanarAction" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcStructuralSurfaceAction" ],
      "fields" : { }
    },
    "IfcStructuralPointAction" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcStructuralAction" ],
      "fields" : { }
    },
    "IfcStructuralPointConnection" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcStructuralConnection" ],
      "fields" : {
        "ConditionCoordinateSystem" : {
          "type" : "IfcAxis2Placement3D",
          "reference" : true,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcStructuralPointReaction" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcStructuralReaction" ],
      "fields" : { }
    },
    "IfcStructuralReaction" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcStructuralActivity" ],
      "fields" : { }
    },
    "IfcStructuralResultGroup" : {
      "domain" : "geometry",
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
    "IfcStructuralSurfaceAction" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcStructuralAction" ],
      "fields" : {
        "ProjectedOrTrue" : {
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
    "IfcStructuralSurfaceConnection" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcStructuralConnection" ],
      "fields" : { }
    },
    "IfcStructuralSurfaceMember" : {
      "domain" : "geometry",
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
      "domain" : "geometry",
      "superclasses" : [ "IfcStructuralSurfaceMember" ],
      "fields" : { }
    },
    "IfcStructuralSurfaceReaction" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcStructuralReaction" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcStyleModel" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcRepresentation" ],
      "fields" : { }
    },
    "IfcStyledItem" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcRepresentationItem" ],
      "fields" : {
        "Item" : {
          "type" : "IfcRepresentationItem",
          "reference" : true,
          "many" : false,
          "inverse" : true
        },
        "Styles" : {
          "type" : "IfcPresentationStyle",
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
      "domain" : "geometry",
      "superclasses" : [ "IfcStyleModel" ],
      "fields" : { }
    },
    "IfcSubContractResource" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcConstructionResource" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcSubContractResourceType" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcConstructionResourceType" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcSubedge" : {
      "domain" : "geometry",
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
      "domain" : "geometry",
      "superclasses" : [ "IfcGeometricRepresentationItem", "IfcGeometricSetSelect", "IfcSurfaceOrFaceSurface" ],
      "fields" : {
        "Dim" : {
          "type" : "long",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcSurfaceCurve" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcCurve", "IfcCurveOnSurface" ],
      "fields" : {
        "Curve3D" : {
          "type" : "IfcCurve",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "AssociatedGeometry" : {
          "type" : "IfcPcurve",
          "reference" : true,
          "many" : true,
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
    "IfcSurfaceCurveSweptAreaSolid" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcDirectrixCurveSweptAreaSolid" ],
      "fields" : {
        "ReferenceSurface" : {
          "type" : "IfcSurface",
          "reference" : true,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcSurfaceFeature" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcFeatureElement" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "AdheresToElement" : {
          "type" : "IfcRelAdheresToElement",
          "reference" : true,
          "many" : false,
          "inverse" : true
        }
      }
    },
    "IfcSurfaceOfLinearExtrusion" : {
      "domain" : "geometry",
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
      "domain" : "geometry",
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
    "IfcSurfaceReinforcementArea" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcStructuralLoadOrResult" ],
      "fields" : {
        "SurfaceReinforcement1" : {
          "type" : "double",
          "reference" : false,
          "many" : true,
          "inverse" : false
        },
        "SurfaceReinforcement1AsString" : {
          "type" : "string",
          "reference" : false,
          "many" : true,
          "inverse" : false
        },
        "SurfaceReinforcement2" : {
          "type" : "double",
          "reference" : false,
          "many" : true,
          "inverse" : false
        },
        "SurfaceReinforcement2AsString" : {
          "type" : "string",
          "reference" : false,
          "many" : true,
          "inverse" : false
        },
        "ShearReinforcement" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "ShearReinforcementAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcSurfaceStyle" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcPresentationStyle" ],
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
      "domain" : "geometry",
      "superclasses" : [ "IfcPresentationItem", "IfcSurfaceStyleElementSelect" ],
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
      "domain" : "geometry",
      "superclasses" : [ "IfcPresentationItem", "IfcSurfaceStyleElementSelect" ],
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
      "domain" : "geometry",
      "superclasses" : [ "IfcSurfaceStyleShading" ],
      "fields" : {
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
      "domain" : "geometry",
      "superclasses" : [ "IfcPresentationItem", "IfcSurfaceStyleElementSelect" ],
      "fields" : {
        "SurfaceColour" : {
          "type" : "IfcColourRgb",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
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
        }
      }
    },
    "IfcSurfaceStyleWithTextures" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcPresentationItem", "IfcSurfaceStyleElementSelect" ],
      "fields" : {
        "Textures" : {
          "type" : "IfcSurfaceTexture",
          "reference" : true,
          "many" : true,
          "inverse" : true
        }
      }
    },
    "IfcSurfaceTexture" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcPresentationItem" ],
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
        "Mode" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "TextureTransform" : {
          "type" : "IfcCartesianTransformationOperator2D",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "Parameter" : {
          "type" : "string",
          "reference" : false,
          "many" : true,
          "inverse" : false
        },
        "IsMappedBy" : {
          "type" : "IfcTextureCoordinate",
          "reference" : true,
          "many" : true,
          "inverse" : true
        },
        "UsedInStyles" : {
          "type" : "IfcSurfaceStyleWithTextures",
          "reference" : true,
          "many" : true,
          "inverse" : true
        }
      }
    },
    "IfcSweptAreaSolid" : {
      "domain" : "geometry",
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
      "domain" : "geometry",
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
    "IfcSweptDiskSolidPolygonal" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcSweptDiskSolid" ],
      "fields" : {
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
    "IfcSweptSurface" : {
      "domain" : "geometry",
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
        }
      }
    },
    "IfcSwitchingDevice" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcFlowController" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcSwitchingDeviceType" : {
      "domain" : "geometry",
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
    "IfcSystem" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcGroup" ],
      "fields" : {
        "ServicesBuildings" : {
          "type" : "IfcRelServicesBuildings",
          "reference" : true,
          "many" : true,
          "inverse" : true
        },
        "ServicesFacilities" : {
          "type" : "IfcRelReferencedInSpatialStructure",
          "reference" : true,
          "many" : true,
          "inverse" : true
        }
      }
    },
    "IfcSystemFurnitureElement" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcFurnishingElement" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcSystemFurnitureElementType" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcFurnishingElementType" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcTShapeProfileDef" : {
      "domain" : "geometry",
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
        }
      }
    },
    "IfcTable" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcMetricValueSelect", "IfcObjectReferenceSelect" ],
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
          "inverse" : false
        },
        "Columns" : {
          "type" : "IfcTableColumn",
          "reference" : true,
          "many" : true,
          "inverse" : false
        },
        "NumberOfCellsInRow" : {
          "type" : "long",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "NumberOfDataRows" : {
          "type" : "long",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "NumberOfHeadings" : {
          "type" : "long",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcTableColumn" : {
      "domain" : "geometry",
      "superclasses" : [ ],
      "fields" : {
        "Identifier" : {
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
        "Unit" : {
          "type" : "IfcUnit",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "ReferencePath" : {
          "type" : "IfcReference",
          "reference" : true,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcTableRow" : {
      "domain" : "geometry",
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
        }
      }
    },
    "IfcTank" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcFlowStorageDevice" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcTankType" : {
      "domain" : "geometry",
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
      "domain" : "geometry",
      "superclasses" : [ "IfcProcess" ],
      "fields" : {
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
        },
        "TaskTime" : {
          "type" : "IfcTaskTime",
          "reference" : true,
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
    "IfcTaskTime" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcSchedulingTime" ],
      "fields" : {
        "DurationType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "ScheduleDuration" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "ScheduleStart" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "ScheduleFinish" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "EarlyStart" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "EarlyFinish" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "LateStart" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "LateFinish" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "FreeFloat" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "TotalFloat" : {
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
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "ActualDuration" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "ActualStart" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "ActualFinish" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "RemainingTime" : {
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
        }
      }
    },
    "IfcTaskTimeRecurring" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcTaskTime" ],
      "fields" : {
        "Recurrence" : {
          "type" : "IfcRecurrencePattern",
          "reference" : true,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcTaskType" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcTypeProcess" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "WorkMethod" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcTelecomAddress" : {
      "domain" : "geometry",
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
        },
        "MessagingIDs" : {
          "type" : "string",
          "reference" : false,
          "many" : true,
          "inverse" : false
        }
      }
    },
    "IfcTendon" : {
      "domain" : "geometry",
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
      "domain" : "geometry",
      "superclasses" : [ "IfcReinforcingElement" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcTendonAnchorType" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcReinforcingElementType" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcTendonConduit" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcReinforcingElement" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcTendonConduitType" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcReinforcingElementType" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcTendonType" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcReinforcingElementType" ],
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
        "SheathDiameter" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "SheathDiameterAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcTessellatedFaceSet" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcTessellatedItem", "IfcBooleanOperand" ],
      "fields" : {
        "Coordinates" : {
          "type" : "IfcCartesianPointList3D",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "HasColours" : {
          "type" : "IfcIndexedColourMap",
          "reference" : true,
          "many" : true,
          "inverse" : true
        },
        "HasTextures" : {
          "type" : "IfcIndexedTextureMap",
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
    "IfcTessellatedItem" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcGeometricRepresentationItem" ],
      "fields" : { }
    },
    "IfcTextLiteral" : {
      "domain" : "geometry",
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
      "domain" : "geometry",
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
      "domain" : "geometry",
      "superclasses" : [ "IfcPresentationStyle" ],
      "fields" : {
        "TextCharacterAppearance" : {
          "type" : "IfcTextStyleForDefinedFont",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "TextStyle" : {
          "type" : "IfcTextStyleTextModel",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "TextFontStyle" : {
          "type" : "IfcTextFontSelect",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "ModelOrDraughting" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcTextStyleFontModel" : {
      "domain" : "geometry",
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
      "domain" : "geometry",
      "superclasses" : [ "IfcPresentationItem" ],
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
      "domain" : "geometry",
      "superclasses" : [ "IfcPresentationItem" ],
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
    "IfcTextureCoordinate" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcPresentationItem" ],
      "fields" : {
        "Maps" : {
          "type" : "IfcSurfaceTexture",
          "reference" : true,
          "many" : true,
          "inverse" : true
        }
      }
    },
    "IfcTextureCoordinateGenerator" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcTextureCoordinate" ],
      "fields" : {
        "Mode" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "Parameter" : {
          "type" : "double",
          "reference" : false,
          "many" : true,
          "inverse" : false
        },
        "ParameterAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : true,
          "inverse" : false
        }
      }
    },
    "IfcTextureCoordinateIndices" : {
      "domain" : "geometry",
      "superclasses" : [ ],
      "fields" : {
        "TexCoordIndex" : {
          "type" : "long",
          "reference" : false,
          "many" : true,
          "inverse" : false
        },
        "TexCoordsOf" : {
          "type" : "IfcIndexedPolygonalFace",
          "reference" : true,
          "many" : false,
          "inverse" : true
        },
        "ToTexMap" : {
          "type" : "IfcIndexedPolygonalTextureMap",
          "reference" : true,
          "many" : false,
          "inverse" : true
        }
      }
    },
    "IfcTextureCoordinateIndicesWithVoids" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcTextureCoordinateIndices" ],
      "fields" : {
        "InnerTexCoordIndices" : {
          "type" : "ListOfELong",
          "reference" : true,
          "many" : true,
          "inverse" : false
        }
      }
    },
    "IfcTextureMap" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcTextureCoordinate" ],
      "fields" : {
        "Vertices" : {
          "type" : "IfcTextureVertex",
          "reference" : true,
          "many" : true,
          "inverse" : false
        },
        "MappedTo" : {
          "type" : "IfcFace",
          "reference" : true,
          "many" : false,
          "inverse" : true
        }
      }
    },
    "IfcTextureVertex" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcPresentationItem" ],
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
    "IfcTextureVertexList" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcPresentationItem" ],
      "fields" : {
        "TexCoordsList" : {
          "type" : "ListOfIfcParameterValue",
          "reference" : true,
          "many" : true,
          "inverse" : false
        }
      }
    },
    "IfcThirdOrderPolynomialSpiral" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcSpiral" ],
      "fields" : {
        "CubicTerm" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "CubicTermAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "QuadraticTerm" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "QuadraticTermAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "LinearTerm" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "LinearTermAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "ConstantTerm" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "ConstantTermAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcTimePeriod" : {
      "domain" : "geometry",
      "superclasses" : [ ],
      "fields" : {
        "StartTime" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "EndTime" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcTimeSeries" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcMetricValueSelect", "IfcObjectReferenceSelect", "IfcResourceObjectSelect" ],
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
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "EndTime" : {
          "type" : "string",
          "reference" : false,
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
        "HasExternalReference" : {
          "type" : "IfcExternalReferenceRelationship",
          "reference" : true,
          "many" : true,
          "inverse" : true
        }
      }
    },
    "IfcTimeSeriesValue" : {
      "domain" : "geometry",
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
      "domain" : "geometry",
      "superclasses" : [ "IfcRepresentationItem" ],
      "fields" : { }
    },
    "IfcTopologyRepresentation" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcShapeModel" ],
      "fields" : { }
    },
    "IfcToroidalSurface" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcElementarySurface" ],
      "fields" : {
        "MajorRadius" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "MajorRadiusAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "MinorRadius" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "MinorRadiusAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcTrackElement" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcBuiltElement" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcTrackElementType" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcBuiltElementType" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcTransformer" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcEnergyConversionDevice" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcTransformerType" : {
      "domain" : "geometry",
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
      "domain" : "geometry",
      "superclasses" : [ "IfcTransportationDevice" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcTransportElementType" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcTransportationDeviceType" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcTransportationDevice" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcElement" ],
      "fields" : { }
    },
    "IfcTransportationDeviceType" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcElementType" ],
      "fields" : { }
    },
    "IfcTrapeziumProfileDef" : {
      "domain" : "geometry",
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
    "IfcTriangulatedFaceSet" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcTessellatedFaceSet" ],
      "fields" : {
        "Normals" : {
          "type" : "ListOfIfcParameterValue",
          "reference" : true,
          "many" : true,
          "inverse" : false
        },
        "Closed" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "CoordIndex" : {
          "type" : "ListOfELong",
          "reference" : true,
          "many" : true,
          "inverse" : false
        },
        "PnIndex" : {
          "type" : "long",
          "reference" : false,
          "many" : true,
          "inverse" : false
        },
        "NumberOfTriangles" : {
          "type" : "long",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcTriangulatedIrregularNetwork" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcTriangulatedFaceSet" ],
      "fields" : {
        "Flags" : {
          "type" : "long",
          "reference" : false,
          "many" : true,
          "inverse" : false
        }
      }
    },
    "IfcTrimmedCurve" : {
      "domain" : "geometry",
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
    "IfcTubeBundle" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcEnergyConversionDevice" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcTubeBundleType" : {
      "domain" : "geometry",
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
    "IfcTypeObject" : {
      "domain" : "geometry",
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
        "Types" : {
          "type" : "IfcRelDefinesByType",
          "reference" : true,
          "many" : true,
          "inverse" : true
        }
      }
    },
    "IfcTypeProcess" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcTypeObject", "IfcProcessSelect" ],
      "fields" : {
        "Identification" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "LongDescription" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "ProcessType" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "OperatesOn" : {
          "type" : "IfcRelAssignsToProcess",
          "reference" : true,
          "many" : true,
          "inverse" : true
        }
      }
    },
    "IfcTypeProduct" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcTypeObject", "IfcProductSelect" ],
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
        },
        "ReferencedBy" : {
          "type" : "IfcRelAssignsToProduct",
          "reference" : true,
          "many" : true,
          "inverse" : true
        }
      }
    },
    "IfcTypeResource" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcTypeObject", "IfcResourceSelect" ],
      "fields" : {
        "Identification" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "LongDescription" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "ResourceType" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "ResourceOf" : {
          "type" : "IfcRelAssignsToResource",
          "reference" : true,
          "many" : true,
          "inverse" : true
        }
      }
    },
    "IfcUShapeProfileDef" : {
      "domain" : "geometry",
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
        }
      }
    },
    "IfcUnitAssignment" : {
      "domain" : "geometry",
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
    "IfcUnitaryControlElement" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcDistributionControlElement" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcUnitaryControlElementType" : {
      "domain" : "geometry",
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
    "IfcUnitaryEquipment" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcEnergyConversionDevice" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcUnitaryEquipmentType" : {
      "domain" : "geometry",
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
    "IfcValve" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcFlowController" ],
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
      "domain" : "geometry",
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
      "domain" : "geometry",
      "superclasses" : [ "IfcGeometricRepresentationItem", "IfcHatchLineDistanceSelect", "IfcVectorOrDirection" ],
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
    "IfcVehicle" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcTransportationDevice" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcVehicleType" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcTransportationDeviceType" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcVertex" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcTopologicalRepresentationItem" ],
      "fields" : { }
    },
    "IfcVertexLoop" : {
      "domain" : "geometry",
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
      "domain" : "geometry",
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
    "IfcVibrationDamper" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcElementComponent" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcVibrationDamperType" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcElementComponentType" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcVibrationIsolator" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcElementComponent" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcVibrationIsolatorType" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcElementComponentType" ],
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
      "domain" : "geometry",
      "superclasses" : [ "IfcElement" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcVirtualGridIntersection" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcGridPlacementDirectionSelect" ],
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
    "IfcVoidingFeature" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcFeatureElementSubtraction" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcWall" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcBuiltElement" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcWallStandardCase" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcWall" ],
      "fields" : { }
    },
    "IfcWallType" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcBuiltElementType" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcWasteTerminal" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcFlowTerminal" ],
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
      "domain" : "geometry",
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
    "IfcWellKnownText" : {
      "domain" : "geometry",
      "superclasses" : [ ],
      "fields" : {
        "WellKnownText" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "CoordinateReferenceSystem" : {
          "type" : "IfcCoordinateReferenceSystem",
          "reference" : true,
          "many" : false,
          "inverse" : true
        }
      }
    },
    "IfcWindow" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcBuiltElement" ],
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
        },
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "PartitioningType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "UserDefinedPartitioningType" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcWindowLiningProperties" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcPreDefinedPropertySet" ],
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
        "LiningToPanelOffsetX" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "LiningToPanelOffsetXAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "LiningToPanelOffsetY" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "LiningToPanelOffsetYAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcWindowPanelProperties" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcPreDefinedPropertySet" ],
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
    "IfcWindowType" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcBuiltElementType" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "PartitioningType" : {
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
        "UserDefinedPartitioningType" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcWorkCalendar" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcControl" ],
      "fields" : {
        "WorkingTimes" : {
          "type" : "IfcWorkTime",
          "reference" : true,
          "many" : true,
          "inverse" : false
        },
        "ExceptionTimes" : {
          "type" : "IfcWorkTime",
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
    "IfcWorkControl" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcControl" ],
      "fields" : {
        "CreationDate" : {
          "type" : "string",
          "reference" : false,
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
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "TotalFloat" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "StartTime" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "FinishTime" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcWorkPlan" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcWorkControl" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcWorkSchedule" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcWorkControl" ],
      "fields" : {
        "PredefinedType" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcWorkTime" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcSchedulingTime" ],
      "fields" : {
        "RecurrencePattern" : {
          "type" : "IfcRecurrencePattern",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "StartDate" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "FinishDate" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcZShapeProfileDef" : {
      "domain" : "geometry",
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
      "domain" : "geometry",
      "superclasses" : [ "IfcSystem" ],
      "fields" : {
        "LongName" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcAbsorbedDoseMeasure" : {
      "domain" : "geometry",
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
      "domain" : "geometry",
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
      "domain" : "geometry",
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
      "domain" : "geometry",
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
    "IfcAreaDensityMeasure" : {
      "domain" : "geometry",
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
      "domain" : "geometry",
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
    "IfcBinary" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcSimpleValue" ],
      "fields" : {
        "wrappedValue" : {
          "type" : "bytearray",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcBoolean" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcModulusOfRotationalSubgradeReactionSelect", "IfcModulusOfSubgradeReactionSelect", "IfcModulusOfTranslationalSubgradeReactionSelect", "IfcRotationalStiffnessSelect", "IfcSimpleValue", "IfcTranslationalStiffnessSelect", "IfcWarpingStiffnessSelect", "IfcValue" ],
      "fields" : {
        "wrappedValue" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcCardinalPointReference" : {
      "domain" : "geometry",
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
    "IfcContextDependentMeasure" : {
      "domain" : "geometry",
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
      "domain" : "geometry",
      "superclasses" : [ "IfcMeasureValue" ],
      "fields" : {
        "wrappedValue" : {
          "type" : "long",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcCurvatureMeasure" : {
      "domain" : "geometry",
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
    "IfcDate" : {
      "domain" : "geometry",
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
    "IfcDateTime" : {
      "domain" : "geometry",
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
    "IfcDayInMonthNumber" : {
      "domain" : "geometry",
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
    "IfcDayInWeekNumber" : {
      "domain" : "geometry",
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
      "domain" : "geometry",
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
      "domain" : "geometry",
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
      "domain" : "geometry",
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
    "IfcDuration" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcSimpleValue", "IfcTimeOrRatioSelect" ],
      "fields" : {
        "wrappedValue" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcDynamicViscosityMeasure" : {
      "domain" : "geometry",
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
      "domain" : "geometry",
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
      "domain" : "geometry",
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
      "domain" : "geometry",
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
      "domain" : "geometry",
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
      "domain" : "geometry",
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
      "domain" : "geometry",
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
      "domain" : "geometry",
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
      "domain" : "geometry",
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
      "domain" : "geometry",
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
      "domain" : "geometry",
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
      "domain" : "geometry",
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
      "domain" : "geometry",
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
      "domain" : "geometry",
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
      "domain" : "geometry",
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
      "domain" : "geometry",
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
    "IfcIdentifier" : {
      "domain" : "geometry",
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
      "domain" : "geometry",
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
      "domain" : "geometry",
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
      "domain" : "geometry",
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
      "domain" : "geometry",
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
      "domain" : "geometry",
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
      "domain" : "geometry",
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
      "domain" : "geometry",
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
      "domain" : "geometry",
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
    "IfcLengthMeasure" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcBendingParameterSelect", "IfcCurveMeasureSelect", "IfcMeasureValue", "IfcSizeSelect" ],
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
      "domain" : "geometry",
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
      "domain" : "geometry",
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
      "domain" : "geometry",
      "superclasses" : [ "IfcDerivedMeasureValue", "IfcTranslationalStiffnessSelect" ],
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
      "domain" : "geometry",
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
      "domain" : "geometry",
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
      "domain" : "geometry",
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
      "domain" : "geometry",
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
      "domain" : "geometry",
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
      "domain" : "geometry",
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
      "domain" : "geometry",
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
      "domain" : "geometry",
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
      "domain" : "geometry",
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
      "domain" : "geometry",
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
      "domain" : "geometry",
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
    "IfcModulusOfElasticityMeasure" : {
      "domain" : "geometry",
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
      "domain" : "geometry",
      "superclasses" : [ "IfcDerivedMeasureValue", "IfcModulusOfTranslationalSubgradeReactionSelect" ],
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
      "domain" : "geometry",
      "superclasses" : [ "IfcDerivedMeasureValue", "IfcModulusOfRotationalSubgradeReactionSelect" ],
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
      "domain" : "geometry",
      "superclasses" : [ "IfcDerivedMeasureValue", "IfcModulusOfSubgradeReactionSelect" ],
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
      "domain" : "geometry",
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
      "domain" : "geometry",
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
      "domain" : "geometry",
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
      "domain" : "geometry",
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
    "IfcMonthInYearNumber" : {
      "domain" : "geometry",
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
      "domain" : "geometry",
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
      "domain" : "geometry",
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
      "domain" : "geometry",
      "superclasses" : [ "IfcCurveMeasureSelect", "IfcMeasureValue", "IfcTrimmingSelect" ],
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
      "domain" : "geometry",
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
      "domain" : "geometry",
      "superclasses" : [ "IfcBendingParameterSelect", "IfcMeasureValue" ],
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
      "domain" : "geometry",
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
      "domain" : "geometry",
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
      "domain" : "geometry",
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
      "domain" : "geometry",
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
      "domain" : "geometry",
      "superclasses" : [ "IfcMeasureValue", "IfcSizeSelect", "IfcTimeOrRatioSelect" ],
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
      "domain" : "geometry",
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
      "domain" : "geometry",
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
      "domain" : "geometry",
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
      "domain" : "geometry",
      "superclasses" : [ "IfcDerivedMeasureValue", "IfcRotationalStiffnessSelect" ],
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
      "domain" : "geometry",
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
      "domain" : "geometry",
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
      "domain" : "geometry",
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
      "domain" : "geometry",
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
    "IfcSoundPowerLevelMeasure" : {
      "domain" : "geometry",
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
    "IfcSoundPowerMeasure" : {
      "domain" : "geometry",
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
    "IfcSoundPressureLevelMeasure" : {
      "domain" : "geometry",
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
      "domain" : "geometry",
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
      "domain" : "geometry",
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
      "domain" : "geometry",
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
      "domain" : "geometry",
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
    "IfcStrippedOptional" : {
      "domain" : "geometry",
      "superclasses" : [ ],
      "fields" : {
        "wrappedValue" : {
          "type" : "enum",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "IfcTemperatureGradientMeasure" : {
      "domain" : "geometry",
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
    "IfcTemperatureRateOfChangeMeasure" : {
      "domain" : "geometry",
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
      "domain" : "geometry",
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
    "IfcTextAlignment" : {
      "domain" : "geometry",
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
      "domain" : "geometry",
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
      "domain" : "geometry",
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
      "domain" : "geometry",
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
      "domain" : "geometry",
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
      "domain" : "geometry",
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
      "domain" : "geometry",
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
      "domain" : "geometry",
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
      "domain" : "geometry",
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
      "domain" : "geometry",
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
    "IfcTime" : {
      "domain" : "geometry",
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
    "IfcTimeMeasure" : {
      "domain" : "geometry",
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
      "domain" : "geometry",
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
    "IfcTorqueMeasure" : {
      "domain" : "geometry",
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
    "IfcURIReference" : {
      "domain" : "geometry",
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
    "IfcVaporPermeabilityMeasure" : {
      "domain" : "geometry",
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
      "domain" : "geometry",
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
      "domain" : "geometry",
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
      "domain" : "geometry",
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
      "domain" : "geometry",
      "superclasses" : [ "IfcDerivedMeasureValue", "IfcWarpingStiffnessSelect" ],
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
    "IfcWellKnownTextLiteral" : {
      "domain" : "geometry",
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
    "IfcBoxAlignment" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcLabel" ],
      "fields" : { }
    },
    "IfcCompoundPlaneAngleMeasure" : {
      "domain" : "geometry",
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
    "IfcLanguageId" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcIdentifier" ],
      "fields" : { }
    },
    "IfcNonNegativeLengthMeasure" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcLengthMeasure", "IfcMeasureValue" ],
      "fields" : { }
    },
    "IfcNormalisedRatioMeasure" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcRatioMeasure", "IfcColourOrFactor", "IfcMeasureValue", "IfcSizeSelect" ],
      "fields" : { }
    },
    "IfcPositiveInteger" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcInteger" ],
      "fields" : { }
    },
    "IfcPositiveLengthMeasure" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcLengthMeasure", "IfcHatchLineDistanceSelect", "IfcMeasureValue", "IfcSizeSelect" ],
      "fields" : { }
    },
    "IfcPositivePlaneAngleMeasure" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcPlaneAngleMeasure", "IfcMeasureValue" ],
      "fields" : { }
    },
    "IfcPositiveRatioMeasure" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcRatioMeasure", "IfcMeasureValue", "IfcSizeSelect" ],
      "fields" : { }
    },
    "IfcActionRequestTypeEnum" : { },
    "IfcActionSourceTypeEnum" : { },
    "IfcActionTypeEnum" : { },
    "IfcActuatorTypeEnum" : { },
    "IfcAddressTypeEnum" : { },
    "IfcAirTerminalBoxTypeEnum" : { },
    "IfcAirTerminalTypeEnum" : { },
    "IfcAirToAirHeatRecoveryTypeEnum" : { },
    "IfcAlarmTypeEnum" : { },
    "IfcAlignmentCantSegmentTypeEnum" : { },
    "IfcAlignmentHorizontalSegmentTypeEnum" : { },
    "IfcAlignmentTypeEnum" : { },
    "IfcAlignmentVerticalSegmentTypeEnum" : { },
    "IfcAnalysisModelTypeEnum" : { },
    "IfcAnalysisTheoryTypeEnum" : { },
    "IfcAnnotationTypeEnum" : { },
    "IfcArithmeticOperatorEnum" : { },
    "IfcAssemblyPlaceEnum" : { },
    "IfcAudioVisualApplianceTypeEnum" : { },
    "IfcBSplineCurveForm" : { },
    "IfcBSplineSurfaceForm" : { },
    "IfcBeamTypeEnum" : { },
    "IfcBearingTypeEnum" : { },
    "IfcBenchmarkEnum" : { },
    "IfcBoilerTypeEnum" : { },
    "IfcBooleanOperator" : { },
    "IfcBridgePartTypeEnum" : { },
    "IfcBridgeTypeEnum" : { },
    "IfcBuildingElementPartTypeEnum" : { },
    "IfcBuildingElementProxyTypeEnum" : { },
    "IfcBuildingSystemTypeEnum" : { },
    "IfcBuiltSystemTypeEnum" : { },
    "IfcBurnerTypeEnum" : { },
    "IfcCableCarrierFittingTypeEnum" : { },
    "IfcCableCarrierSegmentTypeEnum" : { },
    "IfcCableFittingTypeEnum" : { },
    "IfcCableSegmentTypeEnum" : { },
    "IfcCaissonFoundationTypeEnum" : { },
    "IfcChangeActionEnum" : { },
    "IfcChillerTypeEnum" : { },
    "IfcChimneyTypeEnum" : { },
    "IfcCoilTypeEnum" : { },
    "IfcColumnTypeEnum" : { },
    "IfcCommunicationsApplianceTypeEnum" : { },
    "IfcComplexPropertyTemplateTypeEnum" : { },
    "IfcCompressorTypeEnum" : { },
    "IfcCondenserTypeEnum" : { },
    "IfcConnectionTypeEnum" : { },
    "IfcConstraintEnum" : { },
    "IfcConstructionEquipmentResourceTypeEnum" : { },
    "IfcConstructionMaterialResourceTypeEnum" : { },
    "IfcConstructionProductResourceTypeEnum" : { },
    "IfcControllerTypeEnum" : { },
    "IfcConveyorSegmentTypeEnum" : { },
    "IfcCooledBeamTypeEnum" : { },
    "IfcCoolingTowerTypeEnum" : { },
    "IfcCostItemTypeEnum" : { },
    "IfcCostScheduleTypeEnum" : { },
    "IfcCourseTypeEnum" : { },
    "IfcCoveringTypeEnum" : { },
    "IfcCrewResourceTypeEnum" : { },
    "IfcCurtainWallTypeEnum" : { },
    "IfcCurveInterpolationEnum" : { },
    "IfcDamperTypeEnum" : { },
    "IfcDataOriginEnum" : { },
    "IfcDerivedUnitEnum" : { },
    "IfcDirectionSenseEnum" : { },
    "IfcDiscreteAccessoryTypeEnum" : { },
    "IfcDistributionBoardTypeEnum" : { },
    "IfcDistributionChamberElementTypeEnum" : { },
    "IfcDistributionPortTypeEnum" : { },
    "IfcDistributionSystemEnum" : { },
    "IfcDocumentConfidentialityEnum" : { },
    "IfcDocumentStatusEnum" : { },
    "IfcDoorPanelOperationEnum" : { },
    "IfcDoorPanelPositionEnum" : { },
    "IfcDoorTypeEnum" : { },
    "IfcDoorTypeOperationEnum" : { },
    "IfcDuctFittingTypeEnum" : { },
    "IfcDuctSegmentTypeEnum" : { },
    "IfcDuctSilencerTypeEnum" : { },
    "IfcEarthworksCutTypeEnum" : { },
    "IfcEarthworksFillTypeEnum" : { },
    "IfcElectricApplianceTypeEnum" : { },
    "IfcElectricDistributionBoardTypeEnum" : { },
    "IfcElectricFlowStorageDeviceTypeEnum" : { },
    "IfcElectricFlowTreatmentDeviceTypeEnum" : { },
    "IfcElectricGeneratorTypeEnum" : { },
    "IfcElectricMotorTypeEnum" : { },
    "IfcElectricTimeControlTypeEnum" : { },
    "IfcElementAssemblyTypeEnum" : { },
    "IfcElementCompositionEnum" : { },
    "IfcEngineTypeEnum" : { },
    "IfcEvaporativeCoolerTypeEnum" : { },
    "IfcEvaporatorTypeEnum" : { },
    "IfcEventTriggerTypeEnum" : { },
    "IfcEventTypeEnum" : { },
    "IfcExternalSpatialElementTypeEnum" : { },
    "IfcFacilityPartCommonTypeEnum" : { },
    "IfcFacilityUsageEnum" : { },
    "IfcFanTypeEnum" : { },
    "IfcFastenerTypeEnum" : { },
    "IfcFilterTypeEnum" : { },
    "IfcFireSuppressionTerminalTypeEnum" : { },
    "IfcFlowDirectionEnum" : { },
    "IfcFlowInstrumentTypeEnum" : { },
    "IfcFlowMeterTypeEnum" : { },
    "IfcFootingTypeEnum" : { },
    "IfcFurnitureTypeEnum" : { },
    "IfcGeographicElementTypeEnum" : { },
    "IfcGeometricProjectionEnum" : { },
    "IfcGeotechnicalStratumTypeEnum" : { },
    "IfcGlobalOrLocalEnum" : { },
    "IfcGridTypeEnum" : { },
    "IfcHeatExchangerTypeEnum" : { },
    "IfcHumidifierTypeEnum" : { },
    "IfcImpactProtectionDeviceTypeEnum" : { },
    "IfcInterceptorTypeEnum" : { },
    "IfcInternalOrExternalEnum" : { },
    "IfcInventoryTypeEnum" : { },
    "IfcJunctionBoxTypeEnum" : { },
    "IfcKerbTypeEnum" : { },
    "IfcKnotType" : { },
    "IfcLaborResourceTypeEnum" : { },
    "IfcLampTypeEnum" : { },
    "IfcLayerSetDirectionEnum" : { },
    "IfcLightDistributionCurveEnum" : { },
    "IfcLightEmissionSourceEnum" : { },
    "IfcLightFixtureTypeEnum" : { },
    "IfcLiquidTerminalTypeEnum" : { },
    "IfcLoadGroupTypeEnum" : { },
    "IfcLogicalOperatorEnum" : { },
    "IfcMarineFacilityTypeEnum" : { },
    "IfcMarinePartTypeEnum" : { },
    "IfcMechanicalFastenerTypeEnum" : { },
    "IfcMedicalDeviceTypeEnum" : { },
    "IfcMemberTypeEnum" : { },
    "IfcMobileTelecommunicationsApplianceTypeEnum" : { },
    "IfcMooringDeviceTypeEnum" : { },
    "IfcMotorConnectionTypeEnum" : { },
    "IfcNavigationElementTypeEnum" : { },
    "IfcObjectiveEnum" : { },
    "IfcOccupantTypeEnum" : { },
    "IfcOpeningElementTypeEnum" : { },
    "IfcOutletTypeEnum" : { },
    "IfcPavementTypeEnum" : { },
    "IfcPerformanceHistoryTypeEnum" : { },
    "IfcPermeableCoveringOperationEnum" : { },
    "IfcPermitTypeEnum" : { },
    "IfcPhysicalOrVirtualEnum" : { },
    "IfcPileConstructionEnum" : { },
    "IfcPileTypeEnum" : { },
    "IfcPipeFittingTypeEnum" : { },
    "IfcPipeSegmentTypeEnum" : { },
    "IfcPlateTypeEnum" : { },
    "IfcPreferredSurfaceCurveRepresentation" : { },
    "IfcProcedureTypeEnum" : { },
    "IfcProfileTypeEnum" : { },
    "IfcProjectOrderTypeEnum" : { },
    "IfcProjectedOrTrueLengthEnum" : { },
    "IfcProjectionElementTypeEnum" : { },
    "IfcPropertySetTemplateTypeEnum" : { },
    "IfcProtectiveDeviceTrippingUnitTypeEnum" : { },
    "IfcProtectiveDeviceTypeEnum" : { },
    "IfcPumpTypeEnum" : { },
    "IfcRailTypeEnum" : { },
    "IfcRailingTypeEnum" : { },
    "IfcRailwayPartTypeEnum" : { },
    "IfcRailwayTypeEnum" : { },
    "IfcRampFlightTypeEnum" : { },
    "IfcRampTypeEnum" : { },
    "IfcRecurrenceTypeEnum" : { },
    "IfcReferentTypeEnum" : { },
    "IfcReflectanceMethodEnum" : { },
    "IfcReinforcedSoilTypeEnum" : { },
    "IfcReinforcingBarRoleEnum" : { },
    "IfcReinforcingBarSurfaceEnum" : { },
    "IfcReinforcingBarTypeEnum" : { },
    "IfcReinforcingMeshTypeEnum" : { },
    "IfcRoadPartTypeEnum" : { },
    "IfcRoadTypeEnum" : { },
    "IfcRoleEnum" : { },
    "IfcRoofTypeEnum" : { },
    "IfcSIPrefix" : { },
    "IfcSIUnitName" : { },
    "IfcSanitaryTerminalTypeEnum" : { },
    "IfcSectionTypeEnum" : { },
    "IfcSensorTypeEnum" : { },
    "IfcSequenceEnum" : { },
    "IfcShadingDeviceTypeEnum" : { },
    "IfcSignTypeEnum" : { },
    "IfcSignalTypeEnum" : { },
    "IfcSimplePropertyTemplateTypeEnum" : { },
    "IfcSlabTypeEnum" : { },
    "IfcSolarDeviceTypeEnum" : { },
    "IfcSpaceHeaterTypeEnum" : { },
    "IfcSpaceTypeEnum" : { },
    "IfcSpatialZoneTypeEnum" : { },
    "IfcStackTerminalTypeEnum" : { },
    "IfcStairFlightTypeEnum" : { },
    "IfcStairTypeEnum" : { },
    "IfcStateEnum" : { },
    "IfcStructuralCurveActivityTypeEnum" : { },
    "IfcStructuralCurveMemberTypeEnum" : { },
    "IfcStructuralSurfaceActivityTypeEnum" : { },
    "IfcStructuralSurfaceMemberTypeEnum" : { },
    "IfcSubContractResourceTypeEnum" : { },
    "IfcSurfaceFeatureTypeEnum" : { },
    "IfcSurfaceSide" : { },
    "IfcSwitchingDeviceTypeEnum" : { },
    "IfcSystemFurnitureElementTypeEnum" : { },
    "IfcTankTypeEnum" : { },
    "IfcTaskDurationEnum" : { },
    "IfcTaskTypeEnum" : { },
    "IfcTendonAnchorTypeEnum" : { },
    "IfcTendonConduitTypeEnum" : { },
    "IfcTendonTypeEnum" : { },
    "IfcTextPath" : { },
    "IfcTimeSeriesDataTypeEnum" : { },
    "IfcTrackElementTypeEnum" : { },
    "IfcTransformerTypeEnum" : { },
    "IfcTransitionCode" : { },
    "IfcTransportElementTypeEnum" : { },
    "IfcTrimmingPreference" : { },
    "IfcTubeBundleTypeEnum" : { },
    "IfcUnitEnum" : { },
    "IfcUnitaryControlElementTypeEnum" : { },
    "IfcUnitaryEquipmentTypeEnum" : { },
    "IfcValveTypeEnum" : { },
    "IfcVehicleTypeEnum" : { },
    "IfcVibrationDamperTypeEnum" : { },
    "IfcVibrationIsolatorTypeEnum" : { },
    "IfcVirtualElementTypeEnum" : { },
    "IfcVoidingFeatureTypeEnum" : { },
    "IfcWallTypeEnum" : { },
    "IfcWasteTerminalTypeEnum" : { },
    "IfcWindowPanelOperationEnum" : { },
    "IfcWindowPanelPositionEnum" : { },
    "IfcWindowTypeEnum" : { },
    "IfcWindowTypePartitioningEnum" : { },
    "IfcWorkCalendarTypeEnum" : { },
    "IfcWorkPlanTypeEnum" : { },
    "IfcWorkScheduleTypeEnum" : { },
    "IfcArcIndex" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcSegmentIndexSelect" ],
      "fields" : {
        "wrappedValue" : {
          "type" : "long",
          "reference" : false,
          "many" : true,
          "inverse" : false
        }
      }
    },
    "IfcComplexNumber" : {
      "domain" : "geometry",
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
    "IfcLineIndex" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcSegmentIndexSelect" ],
      "fields" : {
        "wrappedValue" : {
          "type" : "long",
          "reference" : false,
          "many" : true,
          "inverse" : false
        }
      }
    },
    "IfcActorSelect" : {
      "domain" : "geometry",
      "superclasses" : [ ],
      "fields" : { }
    },
    "IfcAppliedValueSelect" : {
      "domain" : "geometry",
      "superclasses" : [ ],
      "fields" : { }
    },
    "IfcAxis2Placement" : {
      "domain" : "geometry",
      "superclasses" : [ ],
      "fields" : { }
    },
    "IfcBendingParameterSelect" : {
      "domain" : "geometry",
      "superclasses" : [ ],
      "fields" : { }
    },
    "IfcBooleanOperand" : {
      "domain" : "geometry",
      "superclasses" : [ ],
      "fields" : { }
    },
    "IfcClassificationReferenceSelect" : {
      "domain" : "geometry",
      "superclasses" : [ ],
      "fields" : { }
    },
    "IfcClassificationSelect" : {
      "domain" : "geometry",
      "superclasses" : [ ],
      "fields" : { }
    },
    "IfcColour" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcFillStyleSelect" ],
      "fields" : { }
    },
    "IfcColourOrFactor" : {
      "domain" : "geometry",
      "superclasses" : [ ],
      "fields" : { }
    },
    "IfcCoordinateReferenceSystemSelect" : {
      "domain" : "geometry",
      "superclasses" : [ ],
      "fields" : { }
    },
    "IfcCsgSelect" : {
      "domain" : "geometry",
      "superclasses" : [ ],
      "fields" : { }
    },
    "IfcCurveFontOrScaledCurveFontSelect" : {
      "domain" : "geometry",
      "superclasses" : [ ],
      "fields" : { }
    },
    "IfcCurveMeasureSelect" : {
      "domain" : "geometry",
      "superclasses" : [ ],
      "fields" : { }
    },
    "IfcCurveOnSurface" : {
      "domain" : "geometry",
      "superclasses" : [ ],
      "fields" : { }
    },
    "IfcCurveOrEdgeCurve" : {
      "domain" : "geometry",
      "superclasses" : [ ],
      "fields" : { }
    },
    "IfcCurveStyleFontSelect" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcCurveFontOrScaledCurveFontSelect" ],
      "fields" : { }
    },
    "IfcDefinitionSelect" : {
      "domain" : "geometry",
      "superclasses" : [ ],
      "fields" : { }
    },
    "IfcDerivedMeasureValue" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcValue" ],
      "fields" : { }
    },
    "IfcDocumentSelect" : {
      "domain" : "geometry",
      "superclasses" : [ ],
      "fields" : { }
    },
    "IfcFillStyleSelect" : {
      "domain" : "geometry",
      "superclasses" : [ ],
      "fields" : { }
    },
    "IfcGeometricSetSelect" : {
      "domain" : "geometry",
      "superclasses" : [ ],
      "fields" : { }
    },
    "IfcGridPlacementDirectionSelect" : {
      "domain" : "geometry",
      "superclasses" : [ ],
      "fields" : { }
    },
    "IfcHatchLineDistanceSelect" : {
      "domain" : "geometry",
      "superclasses" : [ ],
      "fields" : { }
    },
    "IfcInterferenceSelect" : {
      "domain" : "geometry",
      "superclasses" : [ ],
      "fields" : { }
    },
    "IfcLayeredItem" : {
      "domain" : "geometry",
      "superclasses" : [ ],
      "fields" : { }
    },
    "IfcLibrarySelect" : {
      "domain" : "geometry",
      "superclasses" : [ ],
      "fields" : { }
    },
    "IfcLightDistributionDataSourceSelect" : {
      "domain" : "geometry",
      "superclasses" : [ ],
      "fields" : { }
    },
    "IfcMaterialSelect" : {
      "domain" : "geometry",
      "superclasses" : [ ],
      "fields" : { }
    },
    "IfcMeasureValue" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcValue" ],
      "fields" : { }
    },
    "IfcMetricValueSelect" : {
      "domain" : "geometry",
      "superclasses" : [ ],
      "fields" : { }
    },
    "IfcModulusOfRotationalSubgradeReactionSelect" : {
      "domain" : "geometry",
      "superclasses" : [ ],
      "fields" : { }
    },
    "IfcModulusOfSubgradeReactionSelect" : {
      "domain" : "geometry",
      "superclasses" : [ ],
      "fields" : { }
    },
    "IfcModulusOfTranslationalSubgradeReactionSelect" : {
      "domain" : "geometry",
      "superclasses" : [ ],
      "fields" : { }
    },
    "IfcObjectReferenceSelect" : {
      "domain" : "geometry",
      "superclasses" : [ ],
      "fields" : { }
    },
    "IfcPointOrVertexPoint" : {
      "domain" : "geometry",
      "superclasses" : [ ],
      "fields" : { }
    },
    "IfcProcessSelect" : {
      "domain" : "geometry",
      "superclasses" : [ ],
      "fields" : { }
    },
    "IfcProductRepresentationSelect" : {
      "domain" : "geometry",
      "superclasses" : [ ],
      "fields" : { }
    },
    "IfcProductSelect" : {
      "domain" : "geometry",
      "superclasses" : [ ],
      "fields" : { }
    },
    "IfcPropertySetDefinitionSelect" : {
      "domain" : "geometry",
      "superclasses" : [ ],
      "fields" : { }
    },
    "IfcResourceObjectSelect" : {
      "domain" : "geometry",
      "superclasses" : [ ],
      "fields" : { }
    },
    "IfcResourceSelect" : {
      "domain" : "geometry",
      "superclasses" : [ ],
      "fields" : { }
    },
    "IfcRotationalStiffnessSelect" : {
      "domain" : "geometry",
      "superclasses" : [ ],
      "fields" : { }
    },
    "IfcSegmentIndexSelect" : {
      "domain" : "geometry",
      "superclasses" : [ ],
      "fields" : { }
    },
    "IfcShell" : {
      "domain" : "geometry",
      "superclasses" : [ ],
      "fields" : { }
    },
    "IfcSimpleValue" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcValue" ],
      "fields" : { }
    },
    "IfcSizeSelect" : {
      "domain" : "geometry",
      "superclasses" : [ ],
      "fields" : { }
    },
    "IfcSolidOrShell" : {
      "domain" : "geometry",
      "superclasses" : [ ],
      "fields" : { }
    },
    "IfcSpaceBoundarySelect" : {
      "domain" : "geometry",
      "superclasses" : [ ],
      "fields" : { }
    },
    "IfcSpatialReferenceSelect" : {
      "domain" : "geometry",
      "superclasses" : [ ],
      "fields" : { }
    },
    "IfcSpecularHighlightSelect" : {
      "domain" : "geometry",
      "superclasses" : [ ],
      "fields" : { }
    },
    "IfcStructuralActivityAssignmentSelect" : {
      "domain" : "geometry",
      "superclasses" : [ ],
      "fields" : { }
    },
    "IfcSurfaceOrFaceSurface" : {
      "domain" : "geometry",
      "superclasses" : [ ],
      "fields" : { }
    },
    "IfcSurfaceStyleElementSelect" : {
      "domain" : "geometry",
      "superclasses" : [ ],
      "fields" : { }
    },
    "IfcTextFontSelect" : {
      "domain" : "geometry",
      "superclasses" : [ ],
      "fields" : { }
    },
    "IfcTimeOrRatioSelect" : {
      "domain" : "geometry",
      "superclasses" : [ ],
      "fields" : { }
    },
    "IfcTranslationalStiffnessSelect" : {
      "domain" : "geometry",
      "superclasses" : [ ],
      "fields" : { }
    },
    "IfcTrimmingSelect" : {
      "domain" : "geometry",
      "superclasses" : [ ],
      "fields" : { }
    },
    "IfcUnit" : {
      "domain" : "geometry",
      "superclasses" : [ ],
      "fields" : { }
    },
    "IfcValue" : {
      "domain" : "geometry",
      "superclasses" : [ "IfcAppliedValueSelect", "IfcMetricValueSelect" ],
      "fields" : { }
    },
    "IfcVectorOrDirection" : {
      "domain" : "geometry",
      "superclasses" : [ ],
      "fields" : { }
    },
    "IfcWarpingStiffnessSelect" : {
      "domain" : "geometry",
      "superclasses" : [ ],
      "fields" : { }
    },
    "ListOfIfcCartesianPoint" : {
      "domain" : "geometry",
      "superclasses" : [ ],
      "fields" : {
        "List" : {
          "type" : "IfcCartesianPoint",
          "reference" : true,
          "many" : true,
          "inverse" : false
        }
      }
    },
    "ListOfIfcLengthMeasure" : {
      "domain" : "geometry",
      "superclasses" : [ ],
      "fields" : {
        "List" : {
          "type" : "IfcLengthMeasure",
          "reference" : true,
          "many" : true,
          "inverse" : false
        }
      }
    },
    "ListOfIfcNormalisedRatioMeasure" : {
      "domain" : "geometry",
      "superclasses" : [ ],
      "fields" : {
        "List" : {
          "type" : "IfcNormalisedRatioMeasure",
          "reference" : true,
          "many" : true,
          "inverse" : false
        }
      }
    },
    "ListOfELong" : {
      "domain" : "geometry",
      "superclasses" : [ ],
      "fields" : {
        "List" : {
          "type" : "long",
          "reference" : false,
          "many" : true,
          "inverse" : false
        }
      }
    },
    "ListOfEDouble" : {
      "domain" : "geometry",
      "superclasses" : [ ],
      "fields" : {
        "List" : {
          "type" : "double",
          "reference" : false,
          "many" : true,
          "inverse" : false
        },
        "ListAsString" : {
          "type" : "string",
          "reference" : false,
          "many" : true,
          "inverse" : false
        }
      }
    },
    "ListOfIfcParameterValue" : {
      "domain" : "geometry",
      "superclasses" : [ ],
      "fields" : {
        "List" : {
          "type" : "IfcParameterValue",
          "reference" : true,
          "many" : true,
          "inverse" : false
        }
      }
    }
  }
}