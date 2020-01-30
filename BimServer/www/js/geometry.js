{
  "classes" : {
    "GeometryInfo" : {
      "domain" : "geometry",
      "superclasses" : [ ],
      "fields" : {
        "bounds" : {
          "type" : "Bounds",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "boundsUntransformed" : {
          "type" : "Bounds",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "startVertex" : {
          "type" : "int",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "startIndex" : {
          "type" : "int",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "primitiveCount" : {
          "type" : "int",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "transformation" : {
          "type" : "bytearray",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "data" : {
          "type" : "GeometryData",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "area" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "volume" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "hasTransparency" : {
          "type" : "boolean",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "ifcProductOid" : {
          "type" : "long",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "ifcProductUuid" : {
          "type" : "bytearray",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "ifcProductRid" : {
          "type" : "int",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "density" : {
          "type" : "EFloat",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "boundsMm" : {
          "type" : "Bounds",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "boundsUntransformedMm" : {
          "type" : "Bounds",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "additionalData" : {
          "type" : "string",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "nrColors" : {
          "type" : "int",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "nrVertices" : {
          "type" : "int",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "ifcProductPid" : {
          "type" : "int",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "Vector3f" : {
      "domain" : "geometry",
      "superclasses" : [ ],
      "fields" : {
        "x" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "y" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "z" : {
          "type" : "double",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "Bounds" : {
      "domain" : "geometry",
      "superclasses" : [ ],
      "fields" : {
        "min" : {
          "type" : "Vector3f",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "max" : {
          "type" : "Vector3f",
          "reference" : true,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "Buffer" : {
      "domain" : "geometry",
      "superclasses" : [ ],
      "fields" : {
        "data" : {
          "type" : "bytearray",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "GeometryData" : {
      "domain" : "geometry",
      "superclasses" : [ ],
      "fields" : {
        "nrIndices" : {
          "type" : "int",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "nrVertices" : {
          "type" : "int",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "nrNormals" : {
          "type" : "int",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "nrColors" : {
          "type" : "int",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "indices" : {
          "type" : "Buffer",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "vertices" : {
          "type" : "Buffer",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "verticesQuantized" : {
          "type" : "Buffer",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "normals" : {
          "type" : "Buffer",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "normalsQuantized" : {
          "type" : "Buffer",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "colorsQuantized" : {
          "type" : "Buffer",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "color" : {
          "type" : "Vector4f",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "hasTransparency" : {
          "type" : "boolean",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "reused" : {
          "type" : "int",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "type" : {
          "type" : "short",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "mostUsedColor" : {
          "type" : "Vector4f",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "boundsMm" : {
          "type" : "Bounds",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "saveableTriangles" : {
          "type" : "int",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "colorPack" : {
          "type" : "ColorPack",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "lineIndices" : {
          "type" : "Buffer",
          "reference" : true,
          "many" : false,
          "inverse" : false
        },
        "nrLineIndices" : {
          "type" : "int",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "Vector4f" : {
      "domain" : "geometry",
      "superclasses" : [ ],
      "fields" : {
        "x" : {
          "type" : "EFloat",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "y" : {
          "type" : "EFloat",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "z" : {
          "type" : "EFloat",
          "reference" : false,
          "many" : false,
          "inverse" : false
        },
        "w" : {
          "type" : "EFloat",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    },
    "ColorPack" : {
      "domain" : "geometry",
      "superclasses" : [ ],
      "fields" : {
        "data" : {
          "type" : "bytearray",
          "reference" : false,
          "many" : false,
          "inverse" : false
        }
      }
    }
  }
}