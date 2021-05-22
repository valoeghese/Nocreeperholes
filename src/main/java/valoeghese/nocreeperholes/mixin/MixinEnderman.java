/*
 * NoCreeperHoles
 * Copyright (C) 2021 Valoeghese
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 */

package valoeghese.nocreeperholes.mixin;

import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.minecraft.entity.mob.EndermanEntity;
import net.minecraft.entity.mob.EndermanEntity.PickUpBlockGoal;
import valoeghese.nocreeperholes.Nocreeperholes;

@Mixin(PickUpBlockGoal.class)
public class MixinEnderman {
	@Shadow
	@Final
	private EndermanEntity enderman;

	@Inject(at = @At("HEAD"), method = "canStart", cancellable = true)
	private void onTryStart(CallbackInfoReturnable<Boolean> info) {
		if (!this.enderman.getEntityWorld().getGameRules().getBoolean(Nocreeperholes.endermanGriefing)) {
			info.setReturnValue(false);
		}
	}
}
