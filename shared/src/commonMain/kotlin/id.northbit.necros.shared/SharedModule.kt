package id.northbit.necros.shared

import kotlinx.coroutines.CoroutineDispatcher
import org.koin.core.qualifier.named
import org.koin.dsl.module

val sharedModule = module {
     single<CoroutineDispatcher>(named<MainDispatcher>()) { getDispatcherProvider().main }
     single<CoroutineDispatcher>(named<IoDispatcher>()) { getDispatcherProvider().io }
     single<CoroutineDispatcher>(named<DefaultDispatcher>()) { getDispatcherProvider().default }
}