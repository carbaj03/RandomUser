package com.acv.randomuser.executor;

import java.util.concurrent.Future;

public interface UseCaseInvoker {
  <T> Future<T> execute(UseCaseExecution<T> interactor);
}
