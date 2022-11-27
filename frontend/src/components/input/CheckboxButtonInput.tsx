import React, { useState } from 'react';
import { Button } from '../../components';
import { LabelValuePair, CheckableTagsInputProps } from '../../model/components/input';
import styles from './CheckboxButtonInput.module.css';

const removeAElementInArray = (elementToRemove: any, arr: any[]) => {
  const targetIdx = arr.indexOf(elementToRemove);
  if (targetIdx === -1) return arr;
  const removed = [...arr];
  removed.splice(targetIdx, 1);
  return removed;
};

const CheckboxButtonInput: React.FC<CheckableTagsInputProps> = ({ options, selected, onChange }) => {
  const onSelectedChange: React.MouseEventHandler<HTMLElement> = ({ currentTarget }) => {
    const alreadySelected = selected.includes(currentTarget.id);
    if (alreadySelected)
      onChange(
        removeAElementInArray(currentTarget.id, selected));
    else
      onChange([...selected, currentTarget.id]);
  };

  const selectedClassOrEmpty = (option: LabelValuePair) => selected.includes(option.value) ? styles.selected : '';

  return (
    <div>
      { options.map(option =>
        <Button
          className={`${styles.btn} ${selectedClassOrEmpty(option)}`}
          key={option.value}
          id={option.value}
          label={option.label}
          onClick={onSelectedChange} />
      )}
    </div>
  );
};

export default CheckboxButtonInput;