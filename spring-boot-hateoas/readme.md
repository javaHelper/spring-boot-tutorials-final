# Request

```
http://localhost:8080/api/actor/actors
```

Response
```
{
    "_embedded": {
        "actorModelList": [
            {
                "actorId": 1,
                "firstName": "PENELOPE",
                "lastName": "GUINESS",
                "lastUpdated": "2006-02-15",
                "_links": {
                    "self": {
                        "href": "http://localhost:8080/1"
                    }
                }
            },
            {
                "actorId": 2,
                "firstName": "NICK",
                "lastName": "WAHLBERG",
                "lastUpdated": "2006-02-15",
                "_links": {
                    "self": {
                        "href": "http://localhost:8080/2"
                    }
                }
            },
            {
                "actorId": 3,
                "firstName": "ED",
                "lastName": "CHASE",
                "lastUpdated": "2006-02-15",
                "_links": {
                    "self": {
                        "href": "http://localhost:8080/3"
                    }
                }
            },
            {
                "actorId": 4,
                "firstName": "JENNIFER",
                "lastName": "DAVIS",
                "lastUpdated": "2006-02-15",
                "_links": {
                    "self": {
                        "href": "http://localhost:8080/4"
                    }
                }
            },
            {
                "actorId": 5,
                "firstName": "JOHNNY",
                "lastName": "LOLLOBRIGIDA",
                "lastUpdated": "2006-02-15",
                "_links": {
                    "self": {
                        "href": "http://localhost:8080/5"
                    }
                }
            },
            {
                "actorId": 6,
                "firstName": "BETTE",
                "lastName": "NICHOLSON",
                "lastUpdated": "2006-02-15",
                "_links": {
                    "self": {
                        "href": "http://localhost:8080/6"
                    }
                }
            },
            {
                "actorId": 7,
                "firstName": "GRACE",
                "lastName": "MOSTEL",
                "lastUpdated": "2006-02-15",
                "_links": {
                    "self": {
                        "href": "http://localhost:8080/7"
                    }
                }
            },
            {
                "actorId": 8,
                "firstName": "MATTHEW",
                "lastName": "JOHANSSON",
                "lastUpdated": "2006-02-15",
                "_links": {
                    "self": {
                        "href": "http://localhost:8080/8"
                    }
                }
            },
            {
                "actorId": 9,
                "firstName": "JOE",
                "lastName": "SWANK",
                "lastUpdated": "2006-02-15",
                "_links": {
                    "self": {
                        "href": "http://localhost:8080/9"
                    }
                }
            },
            {
                "actorId": 10,
                "firstName": "CHRISTIAN",
                "lastName": "GABLE",
                "lastUpdated": "2006-02-15",
                "_links": {
                    "self": {
                        "href": "http://localhost:8080/10"
                    }
                }
            },
            {
                "actorId": 11,
                "firstName": "ZERO",
                "lastName": "CAGE",
                "lastUpdated": "2006-02-15",
                "_links": {
                    "self": {
                        "href": "http://localhost:8080/11"
                    }
                }
            },
            {
                "actorId": 12,
                "firstName": "KARL",
                "lastName": "BERRY",
                "lastUpdated": "2006-02-15",
                "_links": {
                    "self": {
                        "href": "http://localhost:8080/12"
                    }
                }
            },
            {
                "actorId": 13,
                "firstName": "UMA",
                "lastName": "WOOD",
                "lastUpdated": "2006-02-15",
                "_links": {
                    "self": {
                        "href": "http://localhost:8080/13"
                    }
                }
            },
            {
                "actorId": 14,
                "firstName": "VIVIEN",
                "lastName": "BERGEN",
                "lastUpdated": "2006-02-15",
                "_links": {
                    "self": {
                        "href": "http://localhost:8080/14"
                    }
                }
            },
            {
                "actorId": 15,
                "firstName": "CUBA",
                "lastName": "OLIVIER",
                "lastUpdated": "2006-02-15",
                "_links": {
                    "self": {
                        "href": "http://localhost:8080/15"
                    }
                }
            },
            {
                "actorId": 16,
                "firstName": "FRED",
                "lastName": "COSTNER",
                "lastUpdated": "2006-02-15",
                "_links": {
                    "self": {
                        "href": "http://localhost:8080/16"
                    }
                }
            },
            {
                "actorId": 17,
                "firstName": "HELEN",
                "lastName": "VOIGHT",
                "lastUpdated": "2006-02-15",
                "_links": {
                    "self": {
                        "href": "http://localhost:8080/17"
                    }
                }
            },
            {
                "actorId": 18,
                "firstName": "DAN",
                "lastName": "TORN",
                "lastUpdated": "2006-02-15",
                "_links": {
                    "self": {
                        "href": "http://localhost:8080/18"
                    }
                }
            },
            {
                "actorId": 19,
                "firstName": "BOB",
                "lastName": "FAWCETT",
                "lastUpdated": "2006-02-15",
                "_links": {
                    "self": {
                        "href": "http://localhost:8080/19"
                    }
                }
            },
            {
                "actorId": 20,
                "firstName": "LUCILLE",
                "lastName": "TRACY",
                "lastUpdated": "2006-02-15",
                "_links": {
                    "self": {
                        "href": "http://localhost:8080/20"
                    }
                }
            }
        ]
    },
    "_links": {
        "first": {
            "href": "http://localhost:8080/api/actor/actors?page=0&size=20"
        },
        "self": {
            "href": "http://localhost:8080/api/actor/actors?page=0&size=20"
        },
        "next": {
            "href": "http://localhost:8080/api/actor/actors?page=1&size=20"
        },
        "last": {
            "href": "http://localhost:8080/api/actor/actors?page=9&size=20"
        }
    },
    "page": {
        "size": 20,
        "totalElements": 200,
        "totalPages": 10,
        "number": 0
    }
}
```


# Request-2

```
http://localhost:8080/api/actor/actors?page=4&size=20
```

Response
```
{
    "_embedded": {
        "actorModelList": [
            {
                "actorId": 81,
                "firstName": "SCARLETT",
                "lastName": "DAMON",
                "lastUpdated": "2006-02-15",
                "_links": {
                    "self": {
                        "href": "http://localhost:8080/81"
                    }
                }
            },
            {
                "actorId": 82,
                "firstName": "WOODY",
                "lastName": "JOLIE",
                "lastUpdated": "2006-02-15",
                "_links": {
                    "self": {
                        "href": "http://localhost:8080/82"
                    }
                }
            },
            {
                "actorId": 83,
                "firstName": "BEN",
                "lastName": "WILLIS",
                "lastUpdated": "2006-02-15",
                "_links": {
                    "self": {
                        "href": "http://localhost:8080/83"
                    }
                }
            },
            {
                "actorId": 84,
                "firstName": "JAMES",
                "lastName": "PITT",
                "lastUpdated": "2006-02-15",
                "_links": {
                    "self": {
                        "href": "http://localhost:8080/84"
                    }
                }
            },
            {
                "actorId": 85,
                "firstName": "MINNIE",
                "lastName": "ZELLWEGER",
                "lastUpdated": "2006-02-15",
                "_links": {
                    "self": {
                        "href": "http://localhost:8080/85"
                    }
                }
            },
            {
                "actorId": 86,
                "firstName": "GREG",
                "lastName": "CHAPLIN",
                "lastUpdated": "2006-02-15",
                "_links": {
                    "self": {
                        "href": "http://localhost:8080/86"
                    }
                }
            },
            {
                "actorId": 87,
                "firstName": "SPENCER",
                "lastName": "PECK",
                "lastUpdated": "2006-02-15",
                "_links": {
                    "self": {
                        "href": "http://localhost:8080/87"
                    }
                }
            },
            {
                "actorId": 88,
                "firstName": "KENNETH",
                "lastName": "PESCI",
                "lastUpdated": "2006-02-15",
                "_links": {
                    "self": {
                        "href": "http://localhost:8080/88"
                    }
                }
            },
            {
                "actorId": 89,
                "firstName": "CHARLIZE",
                "lastName": "DENCH",
                "lastUpdated": "2006-02-15",
                "_links": {
                    "self": {
                        "href": "http://localhost:8080/89"
                    }
                }
            },
            {
                "actorId": 90,
                "firstName": "SEAN",
                "lastName": "GUINESS",
                "lastUpdated": "2006-02-15",
                "_links": {
                    "self": {
                        "href": "http://localhost:8080/90"
                    }
                }
            },
            {
                "actorId": 91,
                "firstName": "CHRISTOPHER",
                "lastName": "BERRY",
                "lastUpdated": "2006-02-15",
                "_links": {
                    "self": {
                        "href": "http://localhost:8080/91"
                    }
                }
            },
            {
                "actorId": 92,
                "firstName": "KIRSTEN",
                "lastName": "AKROYD",
                "lastUpdated": "2006-02-15",
                "_links": {
                    "self": {
                        "href": "http://localhost:8080/92"
                    }
                }
            },
            {
                "actorId": 93,
                "firstName": "ELLEN",
                "lastName": "PRESLEY",
                "lastUpdated": "2006-02-15",
                "_links": {
                    "self": {
                        "href": "http://localhost:8080/93"
                    }
                }
            },
            {
                "actorId": 94,
                "firstName": "KENNETH",
                "lastName": "TORN",
                "lastUpdated": "2006-02-15",
                "_links": {
                    "self": {
                        "href": "http://localhost:8080/94"
                    }
                }
            },
            {
                "actorId": 95,
                "firstName": "DARYL",
                "lastName": "WAHLBERG",
                "lastUpdated": "2006-02-15",
                "_links": {
                    "self": {
                        "href": "http://localhost:8080/95"
                    }
                }
            },
            {
                "actorId": 96,
                "firstName": "GENE",
                "lastName": "WILLIS",
                "lastUpdated": "2006-02-15",
                "_links": {
                    "self": {
                        "href": "http://localhost:8080/96"
                    }
                }
            },
            {
                "actorId": 97,
                "firstName": "MEG",
                "lastName": "HAWKE",
                "lastUpdated": "2006-02-15",
                "_links": {
                    "self": {
                        "href": "http://localhost:8080/97"
                    }
                }
            },
            {
                "actorId": 98,
                "firstName": "CHRIS",
                "lastName": "BRIDGES",
                "lastUpdated": "2006-02-15",
                "_links": {
                    "self": {
                        "href": "http://localhost:8080/98"
                    }
                }
            },
            {
                "actorId": 99,
                "firstName": "JIM",
                "lastName": "MOSTEL",
                "lastUpdated": "2006-02-15",
                "_links": {
                    "self": {
                        "href": "http://localhost:8080/99"
                    }
                }
            },
            {
                "actorId": 100,
                "firstName": "SPENCER",
                "lastName": "DEPP",
                "lastUpdated": "2006-02-15",
                "_links": {
                    "self": {
                        "href": "http://localhost:8080/100"
                    }
                }
            }
        ]
    },
    "_links": {
        "first": {
            "href": "http://localhost:8080/api/actor/actors?page=0&size=20"
        },
        "prev": {
            "href": "http://localhost:8080/api/actor/actors?page=3&size=20"
        },
        "self": {
            "href": "http://localhost:8080/api/actor/actors?page=4&size=20"
        },
        "next": {
            "href": "http://localhost:8080/api/actor/actors?page=5&size=20"
        },
        "last": {
            "href": "http://localhost:8080/api/actor/actors?page=9&size=20"
        }
    },
    "page": {
        "size": 20,
        "totalElements": 200,
        "totalPages": 10,
        "number": 4
    }
}
```