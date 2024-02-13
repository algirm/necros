package id.northbit.necros.shared

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.MainCoroutineDispatcher
import org.koin.core.context.startKoin
import org.koin.core.qualifier.named
import org.koin.test.KoinTest
import org.koin.test.get
import kotlin.test.Test
import kotlin.test.assertTrue

class SharedModuleTest : KoinTest{
    
    @Test
    fun shared_module_should_defines_correct_main_dispatcher() {
        startKoin { 
            modules(sharedModule)
        }
        val mainDispatcher: CoroutineDispatcher = get(named<MainDispatcher>())
        assertTrue(mainDispatcher is MainCoroutineDispatcher, message = "The class of mainDispatcher is ${mainDispatcher::class.simpleName}")
    }
}