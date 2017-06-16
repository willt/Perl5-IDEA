/*
 * Copyright 2015-2017 Alexandr Evstigneev
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package rename;

import com.intellij.testFramework.fixtures.CodeInsightTestUtil;
import com.perl5.lang.perl.idea.refactoring.rename.PerlMemberInplaceRenameHandler;
import org.jetbrains.annotations.NotNull;

public class PerlInlineRenameTest extends PerlRenameTest {


  @Override
  public void testExceptionClassFieldField() {
    //super.testExceptionClassFieldField(); // see https://github.com/Camelcade/Perl5-IDEA/issues/1473
  }

  @Override
  protected void doRenameAtCaret(@NotNull String newName) {
    CodeInsightTestUtil.doInlineRename(new PerlMemberInplaceRenameHandler(), newName, myFixture);
  }
}
