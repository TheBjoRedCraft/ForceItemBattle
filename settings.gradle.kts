plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.8.0"
}
rootProject.name = "ForceItemBattle"

include("force-item-battle-api")
include("force-item-battle-core")
include("force-item-battle-paper")
