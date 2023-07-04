package com.example.markermap.styles

object DarkMapStyle {
    val json = """
       [
           {
               "featureType": "all",
               "elementType": "labels.text",
               "stylers": [
                   {
                       "visibility": "on"
                   }
               ]
           },
           {
               "featureType": "all",
               "elementType": "labels.text.fill",
               "stylers": [
                   {
                       "color": "#ffffff"
                   },
                   {
                       "visibility": "on"
                   }
               ]
           },
           {
               "featureType": "all",
               "elementType": "labels.text.stroke",
               "stylers": [
                   {
                       "visibility": "on"
                   },
                   {
                       "color": "#413c48"
                   },
                   {
                       "weight": "3.40"
                   }
               ]
           },
           {
               "featureType": "administrative",
               "elementType": "geometry.fill",
               "stylers": [
                   {
                       "color": "#2d2867"
                   },
                   {
                       "lightness": 20
                   }
               ]
           },
           {
               "featureType": "administrative",
               "elementType": "geometry.stroke",
               "stylers": [
                   {
                       "color": "#2d2867"
                   },
                   {
                       "lightness": 17
                   },
                   {
                       "weight": 1.2
                   }
               ]
           },
           {
               "featureType": "administrative.neighborhood",
               "elementType": "all",
               "stylers": [
                   {
                       "visibility": "on"
                   }
               ]
           },
           {
               "featureType": "administrative.land_parcel",
               "elementType": "all",
               "stylers": [
                   {
                       "visibility": "on"
                   },
                   {
                       "color": "#2d2867"
                   }
               ]
           },
           {
               "featureType": "administrative.land_parcel",
               "elementType": "geometry",
               "stylers": [
                   {
                       "visibility": "on"
                   },
                   {
                       "color": "#b1a0cb"
                   }
               ]
           },
           {
               "featureType": "landscape",
               "elementType": "geometry",
               "stylers": [
                   {
                       "lightness": "25"
                   },
                   {
                       "visibility": "on"
                   },
                   {
                       "color": "#352A55"
                   }
               ]
           },
           {
               "featureType": "landscape.man_made",
               "elementType": "all",
               "stylers": [
                   {
                       "visibility": "on"
                   },
                   {
                       "color": "#2d2867"
                   }
               ]
           },
           {
               "featureType": "landscape.man_made",
               "elementType": "geometry",
               "stylers": [
                   {
                       "color": "#8074a2"
                   }
               ]
           },
           {
               "featureType": "poi",
               "elementType": "geometry",
               "stylers": [
                   {
                       "color": "#47385f"
                   },
                   {
                       "lightness": 21
                   }
               ]
           },
           {
               "featureType": "poi",
               "elementType": "labels",
               "stylers": [
                   {
                       "visibility": "off"
                   }
               ]
           },
           {
               "featureType": "road.highway",
               "elementType": "geometry.fill",
               "stylers": [
                   {
                       "color": "#836fa1"
                   },
                   {
                       "lightness": 17
                   }
               ]
           },
           {
               "featureType": "road.highway",
               "elementType": "geometry.stroke",
               "stylers": [
                   {
                       "color": "#000000"
                   },
                   {
                       "lightness": 29
                   },
                   {
                       "weight": 0.2
                   }
               ]
           },
           {
               "featureType": "road.arterial",
               "elementType": "geometry",
               "stylers": [
                   {
                       "color": "#b1a0cb"
                   },
                   {
                       "lightness": "8"
                   }
               ]
           },
           {
               "featureType": "road.local",
               "elementType": "geometry",
               "stylers": [
                   {
                       "color": "#A38CE4"
                   },
                   {
                       "lightness": 16
                   }
               ]
           },
           {
               "featureType": "transit",
               "elementType": "geometry",
               "stylers": [
                   {
                       "color": "#af96d9"
                   },
                   {
                       "lightness": 19
                   }
               ]
           },
           {
               "featureType": "water",
               "elementType": "geometry",
               "stylers": [
                   {
                       "color": "#b1a0cb"
                   },
                   {
                       "lightness": 17
                   }
               ]
           },
           {
               "featureType": "water",
               "elementType": "geometry.fill",
               "stylers": [
                   {
                       "color": "#b1a0cb"
                   }
               ]
           }
       ]
    """.trimIndent()

    val json1 = """
        [
            {
                "featureType": "all",
                "elementType": "geometry",
                "stylers": [
                    {
                        "color": "#202c3e"
                    }
                ]
            },
            {
                "featureType": "all",
                "elementType": "labels.text.fill",
                "stylers": [
                    {
                        "gamma": 0.01
                    },
                    {
                        "lightness": 20
                    },
                    {
                        "weight": "1.39"
                    },
                    {
                        "color": "#ffffff"
                    }
                ]
            },
            {
                "featureType": "all",
                "elementType": "labels.text.stroke",
                "stylers": [
                    {
                        "weight": "0.96"
                    },
                    {
                        "saturation": "9"
                    },
                    {
                        "visibility": "on"
                    },
                    {
                        "color": "#000000"
                    }
                ]
            },
            {
                "featureType": "all",
                "elementType": "labels.icon",
                "stylers": [
                    {
                        "visibility": "off"
                    }
                ]
            },
            {
                "featureType": "landscape",
                "elementType": "geometry",
                "stylers": [
                    {
                        "lightness": 30
                    },
                    {
                        "saturation": "9"
                    },
                    {
                        "color": "#29446b"
                    }
                ]
            },
            {
                "featureType": "landscape",
                "elementType": "geometry.fill",
                "stylers": [
                    {
                        "color": "#625b71"
                    }
                ]
            },
            {
                "featureType": "poi",
                "elementType": "geometry",
                "stylers": [
                    {
                        "saturation": 20
                    }
                ]
            },
            {
                "featureType": "poi.park",
                "elementType": "geometry",
                "stylers": [
                    {
                        "lightness": 20
                    },
                    {
                        "saturation": -20
                    }
                ]
            },
            {
                "featureType": "road",
                "elementType": "geometry",
                "stylers": [
                    {
                        "lightness": 10
                    },
                    {
                        "saturation": -30
                    }
                ]
            },
            {
                "featureType": "road",
                "elementType": "geometry.fill",
                "stylers": [
                    {
                        "color": "#193a55"
                    }
                ]
            },
            {
                "featureType": "road",
                "elementType": "geometry.stroke",
                "stylers": [
                    {
                        "saturation": 25
                    },
                    {
                        "lightness": 25
                    },
                    {
                        "weight": "0.01"
                    }
                ]
            },
            {
                "featureType": "water",
                "elementType": "all",
                "stylers": [
                    {
                        "lightness": -20
                    }
                ]
            }
        ]
    """.trimIndent()
}