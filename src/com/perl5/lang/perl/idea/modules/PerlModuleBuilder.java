/*
 * Copyright 2015 Alexandr Evstigneev
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

package com.perl5.lang.perl.idea.modules;

import com.intellij.ide.util.projectWizard.JavaModuleBuilder;
import com.intellij.openapi.module.ModuleType;
import com.intellij.openapi.options.ConfigurationException;
import com.intellij.openapi.projectRoots.SdkTypeId;
import com.intellij.openapi.roots.ModifiableRootModel;
import com.intellij.openapi.util.Pair;
import com.perl5.lang.perl.idea.sdk.PerlSdkType;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hurricup on 28.05.2015.
 */
public class PerlModuleBuilder extends JavaModuleBuilder
{
	private List<Pair<String, String>> mySourcePaths;

	@Override
	public void setupRootModel(ModifiableRootModel rootModel) throws ConfigurationException
	{
		super.setupRootModel(rootModel);
	}

	@Override
	public ModuleType getModuleType()
	{
		return PerlModuleType.getInstance();
	}

	@Override
	public boolean isSuitableSdkType(SdkTypeId sdkType)
	{
		return sdkType == PerlSdkType.getInstance();
	}

	@Override
	public List<Pair<String, String>> getSourcePaths()
	{
		if (mySourcePaths == null)
		{
			final List<Pair<String, String>> paths = new ArrayList<Pair<String, String>>();
			paths.add(Pair.create(getContentEntryPath(), ""));
			return paths;
		}
		return mySourcePaths;
	}

	@Override
	public void setSourcePaths(List<Pair<String, String>> sourcePaths)
	{
		mySourcePaths = sourcePaths != null ? new ArrayList<Pair<String, String>>(sourcePaths) : null;
	}

	@Override
	public void addSourcePath(Pair<String, String> sourcePathInfo)
	{
		if (mySourcePaths == null)
		{
			mySourcePaths = new ArrayList<Pair<String, String>>();
		}
		mySourcePaths.add(sourcePathInfo);
	}
}
