package id.northbit.necros

import id.northbit.necros.shared.comon.Greeting
import mui.material.Box
import mui.material.Typography
import mui.system.sx
import react.FC
import react.Props
import react.create
import react.dom.client.createRoot
import web.cssom.AlignItems
import web.cssom.Display
import web.cssom.FlexDirection
import web.cssom.px
import web.dom.document

fun main() {
    val rootContent = FC {
        Box {
            sx {
                padding = 16.px
                display = Display.flex
                flexDirection = FlexDirection.column
                alignItems = AlignItems.center
            }

            Typography { +Greeting().greet() }
        }
    }

    val App = FC<Props> {
        Box {
            +"Hello, world!"
        }
    }
    
    createRoot(document.getElementById("app")!!).render(
//        App.create()
        rootContent.create()
        
//        buildElement {
//            Box {
//                sx {
//                    padding = 16.px
//                    display = Display.flex
//                    flexDirection = FlexDirection.column
//                    alignItems = AlignItems.center
//                }
//
//                Typography { +"Not implemented yet :-(" }
//            } 
//        }
//        FC { 
//            Box {
//                sx {
//                    padding = 16.px
//                    display = Display.flex
//                    flexDirection = FlexDirection.column
//                    alignItems = AlignItems.center
//                }
//
//                Typography { +"Not implemented yet :-(" }
//            }
//        }
    )
}